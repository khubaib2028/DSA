# Write your MySQL query statement below
SELECT * 
FROM Users 
WHERE mail COLLATE utf8_bin REGEXP '^[A-Za-z][A-Za-z0-9_\\.\\-]*@leetcode\\.com$';