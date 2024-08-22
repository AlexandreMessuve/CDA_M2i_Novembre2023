# borrowing_service

- GET All Borrowings **/borrowings**
- GET One borrowing **/borrowings/{id}**
- POST Create Borrowing **/borrowings/add**
- PUT Update Borrowing **/borrowings/{id}**
- DELETE Borrowing **/borrowings/{id}**

### JSON Format
- POST & PUT
```Json 
{
  "startDate": "2024-08-22",
  "endDate": "2024-08-24",
  "bookId": 1,
  "userId": 1
}
```
- GET
```Json 
{
  "id": 1,
  "startDate": "2024-08-22",
  "endDate": "2024-08-24",
    "book": {
      "id": 1,
      "startDate": "Harry Potter and the Philosopher's Stone",
      "endDate": "...",
      "isbn": "000-000-000",
      "publishDate": "1997-06-26",
      "author": {
        "id": 1,
        "name": "J.K. Rowling",
        "biography": "",
        "birthDate": "1965-07-31"
      }
    },
  "user": {
    "id": 1,
    "name": "alexandre",
    "username": "alex"
  }
}
```