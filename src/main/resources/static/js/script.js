const apiBase = '/api/movies';

// Load trending movies on page load
window.onload = () => {
    fetchTrendingMovies();
};

// Fetch trending movies from backend
function fetchTrendingMovies() {
    fetch(`${apiBase}/trending`)
        .then(res => res.json())
        .then(data => renderMovies(data.results));
}

// Fetch search results
function searchMovies() {
    const query = document.getElementById('searchInput').value.trim();
    if (!query) return;

    fetch(`${apiBase}/search?query=${encodeURIComponent(query)}`)
        .then(res => res.json())
        .then(data => renderMovies(data.results));
}

// Render movie cards to the page
function renderMovies(movies) {
    const container = document.getElementById('movieList');
    container.innerHTML = '';

    movies.forEach(movie => {
        const card = document.createElement('div');
        card.className = 'movie-card';

        const img = document.createElement('img');
        img.src = `https://image.tmdb.org/t/p/w500${movie.poster_path}`;
        img.alt = movie.title;
        img.onclick = () => showMovieDetails(movie.id);

        const title = document.createElement('h3');
        title.textContent = movie.title;

        const rating = document.createElement('p');
        rating.textContent = `⭐ ${movie.vote_average} | ${movie.release_date}`;

        card.appendChild(img);
        card.appendChild(title);
        card.appendChild(rating);
        container.appendChild(card);
    });
}

// Show movie details in modal
function showMovieDetails(movieId) {
    fetch(`${apiBase}/${movieId}`)
        .then(res => res.json())
        .then(movie => {
            const modal = document.getElementById('movieModal');
            const modalContent = document.getElementById('modalContent');

            modalContent.innerHTML = `
                <span class="close-btn" onclick="closeModal()">✖</span>
                <h2>${movie.title}</h2>
                <img src="https://image.tmdb.org/t/p/w500${movie.poster_path}" alt="${movie.title}" />
                <p><strong>Release Date:</strong> ${movie.release_date}</p>
                <p><strong>Rating:</strong> ${movie.vote_average}</p>
                <p>${movie.overview}</p>
            `;
            modal.style.display = 'block';
        });
}

// Close modal
function closeModal() {
    document.getElementById('movieModal').style.display = 'none';
}

// Redirect to home (trending)
function redirectHome() {
    window.location.href = "/";
}

