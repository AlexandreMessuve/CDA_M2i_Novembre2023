# user_service

## Endpoint

- GET All Users **/users**
- GET One User **/users/{id}**
- POST Create User **/users/add**
- PUT Update User **/users/{id}**
- DELETE User **/users/{id}**

### JSON Format
- POST & PUT
```Json 
{
  "name":"alexandre",
  "username":"alex",
  "password":"azerty"
}
```
- GET
```Json 
{
  "id": 1,
  "name":"alexandre",
  "username":"alex"
}
```
