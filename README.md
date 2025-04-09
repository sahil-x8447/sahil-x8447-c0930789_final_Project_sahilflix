# 🎬 SahilFlix

**SahilFlix** is a full-stack Java Spring Boot application that allows users to explore trending movies, view full details, and manage a personal list of favorite films. It integrates with **The Movie Database (TMDb) API** to fetch real-time movie data, rendered dynamically with Thymeleaf templates.

---

## 🚀 Features

- 🔥 Trending Movies shown on homepage
- 🔍 Search movies by title
- 📄 Full movie detail view with poster, rating, release date, and overview
- ❤️ Add/Remove favorites (stored in H2 database)
- 📁 Favorites tab to list all favorited movies
- 🖱️ Clickable SahilFlix logo to return home
- 🧑‍🎓 Fully server-side rendered with **Thymeleaf**
- ✨ Mobile-responsive and visually clean layout

---

## 🛠️ Tech Stack

### ✅ Backend (Spring Boot):

- Java 17+
- Spring Boot Framework
- Thymeleaf (used for all frontend rendering)
- RestTemplate (for calling TMDb API)
- JSON parsing with Jackson
- H2 In-Memory Database
- TMDb API Integration

### ✅ Frontend:

- HTML & CSS (rendered via Thymeleaf)
- Pure Thymeleaf — **no JavaScript used**
- Responsive layout with Flexbox
- Movie data rendered dynamically from backend

---

## 🔑 TMDb API Key Setup

1. Create a TMDb account: [https://www.themoviedb.org/](https://www.themoviedb.org/)
2. Go to your profile settings → API → Apply for a v3 API key
3. Add your key in `src/main/resources/application.properties`:

---

## ▶️ How to Run

1. Clone or download this repository
2. Add your API key in `application.properties`
3. Open terminal in the project folder
4. Run:
   ```bash
   ./gradlew bootRun
   ```

🧠 Developed By
👨‍💻 Sahil Sharma
🎓 Final Project — CSD 4464 (Java Spring Boot)
Lambton College · 2025
