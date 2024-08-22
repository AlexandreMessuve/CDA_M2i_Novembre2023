# author_service

## Endpoint

 - GET All Authors **/authors**
 - GET One Author **/authors/{id}**
 - GET Detail All Authors **/authors/detail**
 - GET Detail One Author **/authors/detail/{id}**
 - GET Search Detail Author **/authors/detail/search?name=? or prefixName=?**
 - GET Search Author **/authors/search?name=? or prefixName=?**
 - POST Create Author **/authors/add** 
 - PUT Update Author **/authors/{id}**
 - DELETE author **/authors/{id}**

### JSON Format
- POST & PUT
```Json 
{
  "name":"J.K. Rowling",
  "biography":"its my biography",
  "birthDate": "1965-07-31"
}
```
- GET
```Json 
{
  "id": 1,
  "name":"J.K. Rowling",
  "biography":"its my biography",
  "birthDate": "1965-07-31"
}
```
- GET Detailed
```Json 
{
  "id": 1,
  "name":"J.K. Rowling",
  "biography":"its my biography",
  "birthDate": "1965-07-31",
  "publishBooks": [
    {
      "id": 1,
      "title":"Harry Potter and the Philosopher's Stone",
      "description":"...",
      "isbn":"000-000-000",
      "publishDate": "1997-06-26",
      "authorId": 1
    }
  ]
}
```