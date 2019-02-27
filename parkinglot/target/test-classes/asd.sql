
	   SELECT * 
	   from  EIP.MCFUNDPRPRODUCT m
	   left join ( SELECT  * FROM EIP.MCFUNDNAV E
	   where  exists (
	    SELECT 1 FROM EIP.	 T WHERE  T.PRDTYPE='0' and T.STATUS in ('0','1','2','7','8')      and E.PRDCODE= T.PRDCODE ) 
          and E.NAVDATE >=  20180101
	   )  a on a.PRDCODE= m.PRDCODE and a.id = 1 
	   left join ( SELECT    *  FROM EIP.MCFUNDNAV F where  exists (
      	SELECT 1 FROM EIP.MCFUNDPRPRODUCT P WHERE  P.PRDTYPE='0' or P.PRDTYPE='B' and P.STATUS in ('0','1','2','7','8') and P.PRDATTR = '4'
          and F.PRDCODE= P.PRDCODE ) 
          and F.NAVDATE >=  20180101
          and F.SEVENDAYANNUAL != 0  
       	) b on b.PRDCODE= m.PRDCODE and b.id = 1
	   left join eip.PHONE_N_PRODUCTDATA n on m.PRDCODE= n.PRDCODE
	   WHERE m.PRDTYPE='0' or m.PRDTYPE='B' and m.STATUS in ('0','1','2','7','8') and m.PRDTEMPLATE!='0103'
          
 order by n.ORDERSORT, m.nav desc
