# -- 코드를 입력하세요
# SELECT FOOD_TYPE, REST_ID, REST_NAME, MAX(FAVORITES)
#   FROM REST_INFO
#  GROUP BY FOOD_TYPE
# # HAVING FAVORITES = MAX(FAVORITES)
#  ORDER BY FOOD_TYPE DESC;

-- 코드를 입력하세요
SELECT R.FOOD_TYPE, R.REST_ID, R.REST_NAME, R.FAVORITES
  FROM REST_INFO R
 WHERE R.FAVORITES IN (SELECT MAX(R2.FAVORITES) 
                      FROM REST_INFO R2
                     GROUP BY R2.FOOD_TYPE)
 GROUP BY R.FOOD_TYPE
 ORDER BY R.FOOD_TYPE DESC;