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
