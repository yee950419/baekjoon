-- 코드를 입력하세요
SELECT UGU.USER_ID, UGU.NICKNAME,
       CONCAT(UGU.CITY, ' ', 
              UGU.STREET_ADDRESS1, ' ', 
              STREET_ADDRESS2
             ) AS 전체주소,
       CONCAT(LEFT(UGU.TLNO, 3), '-', 
              SUBSTRING(UGU.TLNO, 4, 4), '-', 
              RIGHT(UGU.TLNO, 4)
             ) AS TLNO
  FROM USED_GOODS_BOARD UGB
  JOIN USED_GOODS_USER UGU ON (UGB.WRITER_ID = UGU.USER_ID)
 GROUP BY UGB.WRITER_ID
HAVING COUNT(UGB.WRITER_ID) IN (SELECT COUNT(UGB2.WRITER_ID) AS 등록건수
                          FROM USED_GOODS_BOARD UGB2
                         GROUP BY UGB2.WRITER_ID
                        HAVING 등록건수 >= 3)
 ORDER BY UGU.USER_ID DESC;
