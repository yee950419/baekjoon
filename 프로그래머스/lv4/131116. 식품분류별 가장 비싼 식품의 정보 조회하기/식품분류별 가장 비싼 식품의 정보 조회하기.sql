-- 코드를 입력하세요
SELECT FP.CATEGORY, PRICE AS MAX_PRICE, FP.PRODUCT_NAME
  FROM FOOD_PRODUCT FP
 WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
   AND FP.PRICE IN (SELECT MAX(FP2.PRICE)
                      FROM FOOD_PRODUCT FP2
                     WHERE FP.CATEGORY = FP2.CATEGORY
                    GROUP BY FP2.CATEGORY)
 GROUP BY FP.CATEGORY
 ORDER BY FP.PRICE DESC;
