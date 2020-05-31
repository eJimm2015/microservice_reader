# microservice_reader
Repository Git du microservice des lecteurs (Reader).

Afin de lancer le microservice 
- Récupérer le repository
- Lancer un "mvn clean install"
- aller sur : http://localhost:8002/api/swagger-ui.html#/

Quelques détails
- Les dates sont au format YYYY-MM-DD
- L'ID est autogénéré lors de la création. Il ne faut donc pas le renseigner.
- Lors de la mise à jour, les attributs qui ne changent pas seront à null (ou à 0 si c'est une valeur numérique).
