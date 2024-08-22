# author_service

## Endpoint

- GET All Books **/books**
- GET One Book **/books/{id}**
- GET Detail All Books **/books/detail**
- GET Detail One Book **/books/detail/{id}**
- POST Create Book **/books/add**
- PUT Update Book **/books/{id}**
- DELETE Book **/books/{id}**

### JSON Format
- POST & PUT
```Json 
{
  "title":"Harry Potter and the Philosopher's Stone",
  "description":"...",
  "isbn":"000-000-000",
  "publishDate": "1997-06-26",
  "authorId": 1
}
```
- GET
```Json 
{
  "id": 1,
  "title":"Harry Potter and the Philosopher's Stone",
  "description":"...",
  "isbn":"000-000-000",
  "publishDate": "1997-06-26",
  "authorId": 1
}
```
- GET Detailed 
```Json 
{
  "id": 1,
  "title":"Harry Potter and the Philosopher's Stone",
  "description":"...",
  "isbn":"000-000-000",
  "publishDate": "1997-06-26",
  "author": {
    "id": 1,
    "name": "J.K. Rowling",
    "biography": "",
    "birthDate": "1965-07-31"
  }
}
```