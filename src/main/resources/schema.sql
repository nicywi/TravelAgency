-- Continent Table
CREATE TABLE IF NOT EXISTS continent (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
    );

-- Country Table
CREATE TABLE IF NOT EXISTS country (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    continent_id BIGINT,
    FOREIGN KEY (continent_id) REFERENCES continent(id)
    );

-- City Table
CREATE TABLE IF NOT EXISTS city (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country_id BIGINT,
    FOREIGN KEY (country_id) REFERENCES country(id)
    );

-- Airport Table
CREATE TABLE IF NOT EXISTS airport (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city_id BIGINT,
    FOREIGN KEY (city_id) REFERENCES city(id)
    );

-- Hotel Table
CREATE TABLE IF NOT EXISTS hotel (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    stars INT,
    description VARCHAR(1000),
    city_id BIGINT,
    FOREIGN KEY (city_id) REFERENCES city(id)
    );

-- Trip Table
CREATE TABLE IF NOT EXISTS trip (
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
    FOREIGN KEY (departure_city_id) REFERENCES city(id),
    FOREIGN KEY (destination_city_id) REFERENCES city(id)
    );

-- Purchase Table
CREATE TABLE IF NOT EXISTS purchase (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    trip_id BIGINT,
    adult_count INT,
    child_count INT,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (trip_id) REFERENCES trip(id)
    );
