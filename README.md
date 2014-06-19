Documentation
=============

Emailing :
	
- pour configurer le serveur d'envoie d'email il faut configurer le fichier :
		src/main/resources/spring/scheduler.xml à la ligne 22 et mettre faut changer les paramètres avec avec un vrai compte gmail pour pouvoir envoyer des emails
- pour configurer à qui on envoie un email il faut mettre cet email dans la constante SUPPORT_EMAIL de la classe com.qos.monitoring.ParseLogsTask


Postgresql :
- il faut configurer src/main/resources/spring/datasource-config.xml et remplacer la ligne `<context:property-placeholder location="classpath:spring/data-access.properties" system-properties-mode="OVERRIDE"/>` par `<context:property-placeholder location="classpath:spring/data-access-postgresql.properties" system-properties-mode="OVERRIDE"/>` pour activer le postgresql

- il faut configurer la connection au serveur postgre. Dans le fichier `data-access-postgresql.properties` il faut configurer 
```
jdbc.url=
jdbc.username=
jdbc.password=
```
