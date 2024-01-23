-- Continent Table
CREATE TABLE IF NOT EXISTS continents (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
    );

-- Country Table
CREATE TABLE IF NOT EXISTS countries (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    continent_id BIGINT,
    FOREIGN KEY (continent_id) REFERENCES continents(id)
    );

-- City Table
CREATE TABLE IF NOT EXISTS cities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country_id BIGINT,
    FOREIGN KEY (country_id) REFERENCES countries(id)
    );

-- Airport Table
CREATE TABLE IF NOT EXISTS airports (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city_id BIGINT,
    FOREIGN KEY (city_id) REFERENCES cities(id)
    );

-- Hotel Table
CREATE TABLE IF NOT EXISTS hotels (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    stars INT,
    description VARCHAR(1000),
    city_id BIGINT,
    FOREIGN KEY (city_id) REFERENCES cities(id)
    );

-- Trip Table
CREATE TABLE IF NOT EXISTS trips (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    departure_city_id BIGINT,
    destination_city_id BIGINT,
    start_date DATE,
    end_date DATE,
    duration_days INT,
    meal_type VARCHAR(10),
    price_adult DECIMAL(10, 2),
    price_child DECIMAL(10, 2),
    promoted BOOLEAN,
    available_adult_seats INT,
    available_child_seats INT,
    FOREIGN KEY (departure_city_id) REFERENCES cities(id),
    FOREIGN KEY (destination_city_id) REFERENCES cities(id)
    );


-- Purchase Table
CREATE TABLE IF NOT EXISTS purchases (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    trip_id BIGINT,
    adult_count INT,
    child_count INT,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (trip_id) REFERENCES trips(id)
    );