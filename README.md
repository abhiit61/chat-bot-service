
# Chat Bot Service

A lightweight **Spring Boot** microservice that integrates with **Google Gemini AI** to provide an intelligent chat interface. This service exposes a REST API that takes user queries and returns generated answers using the Gemini Large Language Model.

## 🚀 Features

* **AI Integration**: Powered by Google Gemini.
* **RESTful Interface**: Simple POST endpoint for easy integration with frontend or mobile apps.
* **Environment Security**: Uses system environment variables for GEMINI API keys.
* **Postman Ready**: Easily testable with common API development tools.

---

## 🛠️ Prerequisites

* **Java 17** or higher
* **Maven 3.6+**
* **Google Gemini API Key** (Get one from [Google AI Studio](https://aistudio.google.com/))

---

## ⚙️ Setup & Configuration

### 1. Set Environment Variable

To keep your credentials secure, the application retrieves the API key from your system's environment.

**Windows (Command Prompt):**

```cmd
setx GEMINI_API_KEY "your_api_key_here"

```

**Linux / macOS:**

```bash
export GEMINI_API_KEY='your_api_key_here'

```

### 2. Application Properties

Ensure your `src/main/resources/application.properties` is configured to read the variable:

```properties
# Using Spring AI or custom configuration
gemini.api.key=${GEMINI_API_KEY}

```

---

## 🏃 How to Run

1. **Clone the repository:**
```bash
git clone https://github.com/your-username/chat-bot-service.git
cd chat-bot-service

```


2. **Build the project:**
```bash
mvn clean install

```


3. **Run the Spring Boot application:**
```bash
mvn spring-boot:run

```


The server will start on `http://localhost:8080` by default.

---

## 🧪 API Documentation

### Chat Endpoint

Used to send a prompt to the Gemini AI and receive a response.

* **URL:** `/api/chatbot/chat`
* **Method:** `POST`
* **Content-Type:** `application/json`

#### Request Body:

```json
{
    "query": "How do I explain recursion to a five-year-old?"
}

```

#### Response Body:

```json
{
    "response": "Imagine you have a box, and inside that box is a smaller box..."
}

```

---

## 📮 Testing with Postman

1. Open **Postman**.
2. Create a new **POST** request.
3. Enter the URL: `http://localhost:8080/api/chatbot/chat`.
4. Go to the **Body** tab, select **raw**, and set the format to **JSON**.
5. Paste the request body example from above.
6. Click **Send**.
