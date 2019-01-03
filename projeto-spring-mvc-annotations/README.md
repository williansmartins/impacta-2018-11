#buscar
curl -X GET \
  http://localhost:8080/spring-mvc-annotations/api/v1/despesa/buscar \
  -H 'Postman-Token: 1bc45b15-cff9-4373-b85b-d808b95ceb1e' \
  -H 'cache-control: no-cache'
  
#inserir
curl -X POST \
  http://localhost:8080/spring-mvc-annotations/api/v1/despesa/inserir \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 5a27e0ba-32d8-45b3-aa82-2ce2d03add41' \
  -H 'cache-control: no-cache' \
  -d '{
    "codigo": 2,
    "descricao": "descricao2",
    "categoria": "ALIMENTACAO",
    "data": 1546544787007,
    "valor": 123.4500000000000028421709430404007434844970703125,
    "observacoes": "observacoes"
}'  