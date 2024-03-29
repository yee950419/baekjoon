-- 코드를 입력하세요
SELECT CCC.CAR_ID, CCC.CAR_TYPE,
       TRUNCATE(CCC.DAILY_FEE * 30 * (100 - 
                (SELECT DISCOUNT_RATE
                   FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN CDP2
                  WHERE CDP2.DURATION_TYPE = '30일 이상'
                    AND CCC.CAR_TYPE = CDP2.CAR_TYPE)) / 100, 0) AS FEE
  FROM CAR_RENTAL_COMPANY_CAR CCC
  JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY CRH ON (CCC.CAR_ID = CRH.CAR_ID)
  JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN CDP ON (CCC.CAR_TYPE = CDP.CAR_TYPE)
 WHERE CCC.CAR_TYPE IN ('세단', 'SUV')
   AND CCC.CAR_ID NOT IN (SELECT DISTINCT CRH2.CAR_ID
                        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY CRH2
                       WHERE (CRH2.START_DATE BETWEEN '2022-11-01'
                         AND '2022-11-30')
                          OR (CRH2.END_DATE BETWEEN '2022-11-01'
                         AND '2022-11-30')
                          OR (DATEDIFF(CRH2.END_DATE, '2022-11-30') > 0
                         AND DATEDIFF(CRH2.START_DATE, '2022-11-01') < 0)
                     )
 GROUP BY CCC.CAR_ID
HAVING FEE BETWEEN 500000 AND 2000000
 ORDER BY FEE DESC, CCC.CAR_TYPE, CCC.CAR_ID DESC;
