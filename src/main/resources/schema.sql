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
    purchase_date DATE,
    FOREIGN KEY (trip_id) REFERENCES trips(id),
    CHECK (adult_count >= 0), -- Ensure non-negative counts
    CHECK (child_count >= 0),
    CHECK (adult_count + child_count > 0) -- At least one participant
    );

CREATE TABLE IF NOT EXISTS participants (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    purchase_id BIGINT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    age INT,
    is_adult BOOLEAN,
    FOREIGN KEY (purchase_id) REFERENCES purchases(id)
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    is_Account_mon_expired BOOLEAN DEFAULT FALSE,
    is_account_non_locked BOOLEAN DEFAULT FALSE,
    is_credentials_non_expired BOOLEAN DEFAULT FALSE,
    is_enabled BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS authorities (
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(5)
);

CREATE TABLE IF NOT EXISTS user_authorities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    authority_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (authority_id) REFERENCES authorities(id)
);
