# 📚 Document Management & Q&A Application

This is a Spring Boot-based Document Management and Basic Q&A Application. It allows users to:

- Upload and store documents
- Perform full-text search using PostgreSQL
- Ask questions to retrieve relevant content from uploaded documents
- Authenticate using JWT
- Interact with all APIs via Swagger UI

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- Swagger (OpenAPI via springdoc)

---

## 🚀 Getting Started

### ✅ 1. Clone the Repository

```bash
git clone [https://github.com/your-username/document-management-app.git](https://github.com/dominicsharma98/document)
cd document-management-app
```

## Step 2: Setup Database

1. **Create PostgreSQL Database**  
   Make sure you have a PostgreSQL instance running. Create a database (e.g., `document_db`).

2. **Run DB Scripts**  
   Execute the contents of `DBScripts.txt` provided in the repository to create necessary tables and sample data.

---

## Step 3: Configure Application

**Edit `application.properties`**  
   Update the following configuration values with your local setup:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/document_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

   springdoc.api-docs.path=/v3/api-docs
   springdoc.swagger-ui.path=/swagger-ui.html
   ```
## Step 4: Run the Application

### ✅ Start the Application

1. Open your IDE (e.g., IntelliJ) or terminal.
2. Locate and run the main class:
   com.example.document.DocumentApplication
3. Ensure Java 17 is installed and used for running the project.

---

## Step 5: Access API Documentation via Swagger

Once the application is up and running:

- Open your browser and go to:
  http://localhost:8080/swagger-ui/index.html#/
- You’ll see a list of all available APIs, including:
- **Authentication** (`/api/auth/**`)
- **Document Upload & Retrieval** (`/api/documents/**`)
- **Q&A Interface** (`/api/qa/ask`)

> ⚠️ Some endpoints require a valid JWT token. Use the `/api/auth/login` endpoint to obtain a token and click **Authorize** in Swagger UI to add it for secured requests.

---

## 🔐 Authentication Notes

- The application uses **JWT-based authentication**.
- Sample users are provided via the `DBScripts.txt`.
- After login, use the received token in Swagger UI or any API client like Postman.

---

## 🛠 Technologies Used

- Java 17
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- Swagger (SpringDoc OpenAPI)
- Maven

---


## 📎 Quick Reference

| Feature         | Endpoint                    | Notes                                |
|----------------|-----------------------------|--------------------------------------|
| Login           | `/api/auth/login`           | Returns JWT token                    |
| Upload Document | `/api/documents/upload`     | Requires `title`, `author`, `type`, and file |
| Search Document | `/api/qa/ask?question=...`  | Full-text snippet response           |
| Filter/Search   | `/api/documents/filter`     | Supports `author` & `type` filters   |

---

## 📄 License

MIT
