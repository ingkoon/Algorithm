# LeetCode 풀이 자동화 아키텍처

`src/leetcode` 패키지의 풀이 변경 사항을 **별도 브랜치 → PR(자동 템플릿) → Claude 자동 리뷰** 흐름으로
처리하기 위한 설계 문서.

---

## 1. 목표

| # | 요구사항 | 해결 방식 |
|---|----------|-----------|
| 1 | `src/leetcode` 변경분을 별도 브랜치로 분리 | 로컬 헬퍼 스크립트 (`new-leetcode.*`) |
| 2 | PR 생성 시 PR 템플릿 자동 적용 | `.github/PULL_REQUEST_TEMPLATE.md` |
| 3 | PR 등록 시 Claude가 자동 코드리뷰 | `anthropics/claude-code-action` (GitHub Actions) |

---

## 2. 중요한 전제 — 저장소 구조

이 프로젝트는 **`java_algorithm`가 git 루트가 아니라 하위 폴더**다.

```
C:/Users/dlswo/git/          ← git 루트 (remote: ingkoon/Algorithm)
├─ .github/                  ← ★ 모든 GitHub 설정은 여기에 있어야 동작함
│  ├─ PULL_REQUEST_TEMPLATE.md
│  └─ workflows/
│     └─ claude-review.yml
├─ java_algorithm/
│  └─ src/leetcode/
│     ├─ architecture.md     ← (이 문서)
│     ├─ leetcode207/Solution.java
│     └─ leetcode417/Solution.java
└─ ... (다른 알고리즘 폴더들)
```

> ⚠️ `.github/`를 `java_algorithm/` 안에 두면 GitHub가 인식하지 못한다.
> PR 템플릿/Actions/워크플로우는 **반드시 git 루트의 `.github/`** 에 위치시킨다.

---

## 3. 기존 컨벤션 (그대로 따른다)

- **브랜치**: `solve/leetcode/<문제번호>` (예: `solve/leetcode/207`)
- **커밋**: `[LeetCode-<번호>] done : <문제 제목>` (예: `[LeetCode-207] done : Course Schedule`)
- **패키지**: `src/leetcode/leetcode<번호>/Solution.java`

---

## 4. 전체 흐름

```
[로컬]
 1. new-leetcode 스크립트 실행
      └─ solve/leetcode/<번호> 브랜치 생성 + 패키지 스캐폴딩
 2. Solution.java 작성 & 커밋
 3. git push -u origin solve/leetcode/<번호>
 4. gh pr create  ──→  PR 템플릿 자동 적용

[GitHub]
 5. PR opened 이벤트 발생
 6. claude-review.yml 워크플로우 트리거
      └─ anthropics/claude-code-action 실행
      └─ Claude가 diff 분석 후 리뷰 코멘트 작성
```

---

## 5. 구성 요소 설계

### 5.1 PR 템플릿

`/.github/PULL_REQUEST_TEMPLATE.md` (git 루트 기준)

```markdown
## 📝 문제
- 번호 / 제목:
- 링크: https://leetcode.com/problems/

## 💡 접근 방법
<!-- 어떤 자료구조 / 알고리즘을 사용했는지 -->

## ⏱ 복잡도
- 시간:
- 공간:

## ✅ 체크리스트
- [ ] 엣지 케이스 확인
- [ ] 네이밍 컨벤션 (`leetcode<번호>` 패키지) 준수
- [ ] 테스트 통과

## 🤖 Claude 리뷰 요청 포인트
<!-- 리뷰에서 특히 봐줬으면 하는 부분 -->
```

PR 본문이 비어 있으면 GitHub가 이 템플릿을 자동으로 채워준다.

### 5.2 브랜치/스캐폴딩 헬퍼 (선택, 편의용)

`new-leetcode.ps1` — 번호를 받아 브랜치 생성 + 패키지/파일 골격 생성.

```powershell
param([Parameter(Mandatory)][int]$Number)

git switch -c "solve/leetcode/$Number"

$dir = "src/leetcode/leetcode$Number"
New-Item -ItemType Directory -Force $dir | Out-Null

$file = "$dir/Solution.java"
if (-not (Test-Path $file)) {
@"
package leetcode.leetcode$Number;

import java.util.*;

class Solution {
    // TODO: implement
}
"@ | Out-File -Encoding utf8 $file
}

Write-Host "Created branch solve/leetcode/$Number and $file"
```

> 이 스크립트는 java_algorithm 폴더에서 실행. 경로는 java_algorithm 기준 상대경로.

### 5.3 Claude 자동 리뷰 워크플로우

`/.github/workflows/claude-review.yml` (git 루트 기준)

```yaml
name: Claude PR Review

on:
  pull_request:
    types: [opened, synchronize, reopened]
    paths:
      - "java_algorithm/src/leetcode/**"   # leetcode 변경에만 한정

permissions:
  contents: read
  pull-requests: write
  issues: write

jobs:
  review:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
        with:
          fetch-depth: 0

      - name: Claude Code Review
        uses: anthropics/claude-code-action@v1
        with:
          anthropic_api_key: ${{ secrets.ANTHROPIC_API_KEY }}
          prompt: |
            이 PR은 LeetCode 풀이입니다. 한국어로 리뷰해 주세요:
            1. 정확성 / 엣지 케이스 누락
            2. 시간·공간 복잡도 평가 및 개선 여지
            3. 가독성·네이밍 (패키지 컨벤션 leetcode<번호>)
            4. 더 나은 자료구조/알고리즘 제안
            칭찬보다 개선점 위주로, 코드 라인 단위로 코멘트.
```

> `paths` 필터로 **leetcode 패키지 변경 시에만** 리뷰가 돌도록 비용/노이즈를 제한한다.

---

## 6. 설정 절차 (1회성)

1. **API 키 등록**
   GitHub → repo `Settings` → `Secrets and variables` → `Actions`
   → `New repository secret` → 이름 `ANTHROPIC_API_KEY`, 값에 발급받은 키.
2. **파일 배치**: 위 3개 파일을 git 루트 `.github/`에 커밋.
3. **(대안) GitHub App 방식**: 로컬에서 `claude` CLI 실행 후 `/install-github-app`
   을 사용하면 워크플로우 + 시크릿을 자동 구성해준다.

---

## 7. 일상 사용 흐름 (요약)

```powershell
# 1. 새 문제 시작
./new-leetcode.ps1 -Number 300

# 2. 풀이 작성 후 커밋
git add src/leetcode/leetcode300
git commit -m "[LeetCode-300] done : Longest Increasing Subsequence"

# 3. 푸시 & PR 생성 (템플릿 자동 적용)
git push -u origin solve/leetcode/300
gh pr create --fill --base main

# 4. PR이 열리면 Actions가 Claude 리뷰를 자동 작성
```

---

## 8. 의사결정 / 트레이드오프

- **PR 생성 자체의 완전 자동화는 일부러 제외**했다. "푸시되면 무조건 PR 생성"은
  미완성 풀이까지 PR이 열려 노이즈가 크다. `gh pr create`를 사람이 호출하는 편이 안전.
  필요하면 push 트리거 + `gh pr create` 워크플로우로 확장 가능.
- **`paths` 필터**로 leetcode 외 폴더(다른 알고리즘) 변경은 리뷰 대상에서 제외.
- **리뷰는 Action(API key) 방식 권장** — `pull_request` 이벤트에 바로 반응. `@claude`
  멘션 방식(대화형)은 보조로 함께 둘 수 있다.

---

## 9. 한계 / 주의

- `.github/`가 git 루트에 없으면 **아무것도 동작하지 않는다** (이 repo의 핵심 함정).
- Actions 실행마다 Anthropic API 비용 발생 → `paths` 필터 + 이벤트 타입 제한 필수.
- `pull_request` 워크플로우는 fork PR에서 시크릿 접근이 제한될 수 있음(개인 repo면 무관).
- LeetCode 문제 본문 저작권 때문에 PR/리뷰에 문제 전문 복붙은 지양, 링크로 대체.