-- Continent Table
INSERT INTO continents (name) VALUES ('Europe');
INSERT INTO continents (name) VALUES ('Asia');
INSERT INTO continents (name) VALUES ('Africa');
INSERT INTO continents (name) VALUES ('North America');
INSERT INTO continents (name) VALUES ('South America');

-- Country Table
INSERT INTO countries (name, continent_id) VALUES ('Poland', 1);
INSERT INTO countries (name, continent_id) VALUES ('Italy', 1);
INSERT INTO countries (name, continent_id) VALUES ('France', 1);
INSERT INTO countries (name, continent_id) VALUES ('Switzerland', 1);
INSERT INTO countries (name, continent_id) VALUES ('Austria', 1);
INSERT INTO countries (name, continent_id) VALUES ('Germany', 1);

-- City Tables
-- City Table for Poland
INSERT INTO cities (name, country_id) VALUES
                                        ('Warsaw', 1), ('Karkow', 1), ('Wroclaw', 1), ('Zakopane', 1), ('Poznan', 1),
                                        ('Gdansk', 1), ('Torun', 1), ('Szczecin', 1), ('Gdynia', 1), ('Katowice', 1);

-- City Table for Italy
INSERT INTO cities (name, country_id) VALUES
                                        ('Rome', 2), ('Milan', 2), ('Florence', 2), ('Venice', 2), ('Naples', 2),
                                        ('Turin', 2), ('Bologna', 2), ('Genoa', 2), ('Bari', 2), ('Palermo', 2);
-- City Table for France
INSERT INTO cities (name, country_id) VALUES
                                        ('Paris', 3), ('Marseille', 3), ('Lyon', 3), ('Toulouse', 3), ('Nice', 3),
                                        ('Nantes', 3), ('Strasbourg', 3), ('Montpellier', 3), ('Bordeaux', 3), ('Lille', 3);
-- City Table for Switzerland
INSERT INTO cities (name, country_id) VALUES
                                        ('Zurich', 4), ('Geneva', 4), ('Basel', 4), ('Bern', 4), ('Lausanne', 4),
                                        ('Lucerne', 4), ('St. Moritz', 4), ('Interlaken', 4), ('Lugano', 4), ('Zermatt', 4);
-- City Table for Austria
INSERT INTO cities (name, country_id) VALUES
                                        ('Vienna', 5), ('Salzburg', 5), ('Innsbruck', 5), ('Graz', 5), ('Linz', 5),
                                        ('Klagenfurt', 5), ('Bregenz', 5), ('St. Anton am Arlberg', 5), ('Hallstatt', 5), ('Eisenstadt', 5);
-- City Table for Germany
INSERT INTO cities (name, country_id) VALUES
                                        ('Berlin', 6), ('Munich', 6), ('Hamburg', 6), ('Cologne', 6), ('Frankfurt', 6),
                                        ('Stuttgart', 6), ('Dresden', 6), ('Leipzig', 6), ('Nuremberg', 6), ('Heidelberg', 6);


-- Airport Tables
-- Airport Table for Poland
INSERT INTO airports (name, city_id) VALUES
                                        ('Warsaw Chopin Airport', 1), ('Krakow International Airport', 2), ('Wroclaw Nicolaus Copernicus Airport', 3),
                                        ('Zakopane Airport', 4), ('Poznan–Ławica Airport', 5), ('Gdansk Lech Walesa Airport', 6),
                                        ('Torun Airport', 7), ('Szczecin-Goleniow "Solidarnosc" Airport', 8), ('Gdynia-Kosakowo Airport', 9),
                                        ('Katowice Airport', 10);

-- Airport Table for Italy
INSERT INTO airports (name, city_id) VALUES
                                        ('Leonardo da Vinci-Fiumicino Airport', 11), ('Malpensa Airport', 12), ('Peretola Airport', 13),
                                        ('Marco Polo Airport', 14), ('Capodichino Airport', 15), ('Turin Airport', 16),
                                        ('Guglielmo Marconi Airport', 17), ('Cristoforo Colombo Airport', 18), ('Bari Karol Wojtyła Airport', 19),
                                        ('Falcone-Borsellino Airport', 20);

-- Airport Table for France
INSERT INTO airports (name, city_id) VALUES
                                        ('Charles de Gaulle Airport', 21), ('Marseille Provence Airport', 22), ('Lyon-Saint-Exupéry Airport', 23),
                                        ('Toulouse-Blagnac Airport', 24), ('Nice Côte dAzur Airport', 25), ('Nantes Atlantique Airport', 26),
                                        ('Strasbourg Airport', 27), ('Montpellier-Méditerranée Airport', 28), ('Bordeaux-Mérignac Airport', 29),
                                        ('Lille Airport', 30);
-- Airport Table for Switzerland
INSERT INTO airports (name, city_id) VALUES
                                        ('Zurich Airport', 31), ('Geneva Airport', 32), ('EuroAirport Basel-Mulhouse-Freiburg', 33),
                                        ('Bern Airport', 34), ('Lausanne Airport', 35), ('Lucerne Airport', 36),
                                        ('Engadin Airport', 37), ('Interlaken Airport', 38), ('Lugano Airport', 39), ('Zermatt Airport', 40);

-- Airport Table for Austria
INSERT INTO airports (name, city_id) VALUES
                                        ('Vienna International Airport', 41), ('Salzburg Airport', 42), ('Innsbruck Airport', 43),
                                        ('Graz Airport', 44), ('Linz Airport', 45), ('Klagenfurt Airport', 46),
                                        ('Bregenz Airport', 47), ('St. Anton am Arlberg Airport', 48), ('Salzkammergut Airport', 49), ('Eisenstadt Airport', 50);

-- Airport Table for Germany
INSERT INTO airports (name, city_id) VALUES
                                        ('Berlin Brandenburg Airport', 51), ('Munich Airport', 52), ('Hamburg Airport', 53),
                                        ('Cologne Bonn Airport', 54), ('Frankfurt Airport', 55), ('Stuttgart Airport', 56),
                                        ('Dresden Airport', 57), ('Leipzig/Halle Airport', 58), ('Nuremberg Airport', 59), ('Heidelberg Airport', 60);
-- Hotels

-- Hotel Table for Poland
INSERT INTO hotels (name, stars, description, city_id) VALUES
                                                           ('Warsaw Luxury Suites', 4, 'Modern suites with a view of the city', 1),
                                                           ('Krakow Renaissance Hotel', 5, 'Elegant hotel in the heart of Krakow', 2),
                                                           ('Wroclaw Boutique Residence', 4, 'Charming residence in the historic district', 3),
                                                           ('Zakopane Alpine Lodge', 3, 'Cozy lodge with mountain views', 4),
                                                           ('Poznan Grand Plaza', 4, 'Upscale plaza hotel in the city center', 5),
                                                           ('Gdansk Seaside Resort', 5, 'Luxurious resort with seafront views', 6),
                                                           ('Torun Historical Inn', 3, 'Historical inn with a medieval charm', 7),
                                                           ('Szczecin Harbor View Hotel', 4, 'Hotel offering stunning views of the harbor', 8),
                                                           ('Gdynia Coastal Retreat', 5, 'Relaxing retreat by the Baltic Sea', 9),
                                                           ('Katowice Business Hotel', 4, 'Modern hotel catering to business travelers', 10);

-- Hotel Table for Italy
INSERT INTO hotels (name, stars, description, city_id) VALUES
                                                           ('Milan Grand Hotel', 5, 'Luxury hotel in the heart of Milan', 11),
                                                           ('Florence Renaissance Palace', 4, 'Historic palace turned into a stylish hotel', 12),
                                                           ('Venice Canal View Resort', 5, 'Resort with breathtaking views of the canals', 13),
                                                           ('Naples Seaside Retreat', 4, 'Relaxing retreat by the Bay of Naples', 14),
                                                           ('Turin Urban Suites', 3, 'Contemporary suites in downtown Turin', 15),
                                                           ('Bologna Artistic Boutique', 4, 'Boutique hotel showcasing local art', 16),
                                                           ('Genoa Maritime Hotel', 3, 'Hotel with a maritime theme near the port', 17),
                                                           ('Bari Coastal Resort', 5, 'Seaside resort offering luxury amenities', 18),
                                                           ('Palermo Historical Inn', 4, 'Charming inn in the historic center of Palermo', 19),
                                                           ('Verona Romantic Retreat', 4, 'Romantic retreat in the city of love', 20);

-- Hotel Table for France
INSERT INTO hotels (name, stars, description, city_id) VALUES
                                                           ('Marseille Mediterranean Palace', 5, 'Palatial hotel overlooking the Mediterranean', 21),
                                                           ('Lyon Culinary Haven', 4, 'Hotel for food enthusiasts in the heart of Lyon', 22),
                                                           ('Toulouse Skyline Suites', 3, 'Modern suites with views of the Toulouse skyline', 23),
                                                           ('Nice Riviera Resort', 4, 'Riviera resort with access to private beaches', 24),
                                                           ('Nantes Riverside Retreat', 3, 'Relaxing retreat by the Loire River', 25),
                                                           ('Strasbourg Alsatian Charm', 4, 'Charming hotel with Alsatian influence', 26),
                                                           ('Montpellier Modern Oasis', 3, 'Oasis of modernity in the heart of Montpellier', 27),
                                                           ('Bordeaux Wine Country Inn', 5, 'Inn surrounded by vineyards in Bordeaux wine country', 28),
                                                           ('Lille Grand Plaza', 4, 'Grand plaza hotel in the center of Lille', 29),
                                                           ('Rennes Brittany Hideaway', 3, 'Hideaway in the heart of Brittany', 30);
-- Hotel Table for Switzerland
INSERT INTO hotels (name, stars, description, city_id) VALUES
                                                           ('Zurich Luxury Tower', 5, 'Iconic luxury tower in the heart of Zurich', 31),
                                                           ('Geneva Lakeside Resort', 4, 'Resort with picturesque views of Lake Geneva', 32),
                                                           ('Basel Artistic Retreat', 3, 'Artistic retreat in the cultural city of Basel', 33),
                                                           ('Bern Old Town Hotel', 4, 'Charming hotel in the historic old town of Bern', 34),
                                                           ('Lausanne Lakeside Palace', 5, 'Palatial hotel on the shores of Lake Lausanne', 35),
                                                           ('Lucerne Mountain View Lodge', 4, 'Lodge with stunning mountain views in Lucerne', 36),
                                                           ('St. Moritz Alpine Elegance', 5, 'Elegant alpine hotel in St. Moritz', 37),
                                                           ('Interlaken Lakeside Oasis', 4, 'Oasis by the lake in Interlaken', 38),
                                                           ('Lugano Hillside Retreat', 3, 'Hillside retreat overlooking Lugano', 39),
                                                           ('Zermatt Chalet Escape', 4, 'Escape to a cozy chalet in Zermatt', 40);

-- Hotel Table for Austria
INSERT INTO hotels (name, stars, description, city_id) VALUES
                                                           ('Vienna Royal Palace', 5, 'Royal palace offering opulence in Vienna', 41),
                                                           ('Salzburg Mozart Suites', 4, 'Suites inspired by Mozart in Salzburg', 42),
                                                           ('Innsbruck Alpine View Hotel', 3, 'Hotel with Alpine views in Innsbruck', 43),
                                                           ('Graz City Center Inn', 4, 'Inn located in the heart of Graz', 44),
                                                           ('Linz Danube Riverside Retreat', 3, 'Riverside retreat along the Danube in Linz', 45),
                                                           ('Klagenfurt Lakeside Resort', 4, 'Lakeside resort offering luxury in Klagenfurt', 46),
                                                           ('Bregenz Lakeside Hideaway', 3, 'Hideaway with serene lake views in Bregenz', 47),
                                                           ('St. Anton am Arlberg Alpine Lodge', 4, 'Alpine lodge in the skiing paradise of St. Anton am Arlberg', 48),
                                                           ('Hallstatt Lakeside Retreat', 5, 'Lakeside retreat in the picturesque town of Hallstatt', 49),
                                                           ('Eisenstadt Castle Hotel', 4, 'Castle hotel offering a historic stay in Eisenstadt', 50);

-- Hotel Table for Germany
INSERT INTO hotels (name, stars, description, city_id) VALUES
                                                           ('Berlin Grand Hotel', 5, 'Grand hotel in the vibrant city of Berlin', 51),
                                                           ('Munich Bavarian Charm', 4, 'Charming hotel showcasing Bavarian hospitality in Munich', 52),
                                                           ('Hamburg Harbor View Inn', 3, 'Inn with views of the bustling harbor in Hamburg', 53),
                                                           ('Cologne Cathedral City Hotel', 4, 'Hotel in the shadow of the Cologne Cathedral', 54),
                                                           ('Frankfurt Financial District Suites', 3, 'Suites in the heart of Frankfurts financial district', 55),
                                                           ('Stuttgart Modern Oasis', 4, 'Modern oasis in the automotive hub of Stuttgart', 56),
                                                           ('Dresden Baroque Palace', 3, 'Hotel with Baroque elegance in the city of Dresden', 57),
                                                           ('Leipzig Cultural Inn', 4, 'Inn celebrating the cultural richness of Leipzig', 58),
                                                           ('Nuremberg Castle View Retreat', 3, 'Retreat with views of Nuremberg Castle', 59),
                                                           ('Heidelberg Romantic Getaway', 4, 'Romantic getaway in the historic city of Heidelberg', 60);

-- Trips Table
INSERT INTO trips (departure_city_id, destination_city_id, start_date, end_date, duration_days, meal_type, price_adult, price_child, promoted, available_adult_seats, available_child_seats)
VALUES
    (1, 2, '2024-02-01', '2024-02-10', 10, 'AI', 1200.00, 600.00, true, 150, 10),
    (2, 13, '2024-03-15', '2024-03-18', 3, 'HB', 500.00, 250.00, false, 30, 15),
    (3, 27, '2024-04-01', '2024-04-05', 5, 'BB', 800.00, 400.00, true, 40, 10),
    (4, 38, '2024-05-10', '2024-05-20', 10, 'FB', 1500.00, 1000.00, false, 25, 50),
    (5, 49, '2024-06-05', '2024-06-11', 7, 'AI', 1200.00, 1000.00, true, 35, 12),
    (6, 52, '2024-07-20', '2024-07-30', 10, 'HB', 1800.00, 900.00, false, 150, 10),
    (7, 60, '2024-07-20', '2024-07-30', 10, 'HB', 1800.00, 800.00, false, 30, 10),
    (8, 28, '2024-07-20', '2024-07-30', 10, 'HB', 1100.00, 600.00, true, 28, 20),
    (9, 34, '2024-07-20', '2024-07-30', 10, 'HB', 1100.00, 550.00, false, 30, 0),
    (10, 51, '2024-05-01', '2024-05-08', 7, 'HB', 1100.00, 500.00, false, 30, 14),
    (1, 4, '2024-05-01', '2024-05-10', 10, 'HB', 2000.00, 1200.00, true, 50, 20),
    (2, 11, '2024-05-01', '2024-05-10', 10, 'HB', 1800.00, 1100.00, false, 30, 15),
    (2, 26, '2024-05-01', '2024-05-10', 10, 'BB', 800.00, 400.00, true, 40, 10),
    (2, 39, '2024-05-02', '2024-05-16', 14, 'FB', 1500.00, 750.00, false, 25, 0),
    (1, 42, '2024-05-02', '2024-05-12', 10, 'AI', 2000.00, 1000.00, true, 35, 12),
    (1, 55, '2024-05-02', '2024-05-09', 7, 'HB', 1100.00, 550.00, false, 28, 14),
    (1, 59, '2024-05-02', '2024-05-12', 10, 'HB', 1100.00, 700.00, false, 100, 0),
    (2, 27, '2024-08-20', '2024-09-02', 14, 'HB', 2200.00, 1100.00, false, 70, 50),
    (9, 33, '2024-08-20', '2024-08-31', 14, 'HB', 2200.00, 1200.00, false, 80, 30),
    (10, 52, '2024-08-20', '2024-08-31', 14, 'HB', 2500.00, 1500.00, false, 80, 0),
    (1, 3, '2024-08-01', '2024-08-14', 14, 'AI', 1200.00, 600.00, false, 50, 20),
    (2, 14, '2024-09-15', '2024-09-28', 14, 'HB', 3000.00, 2000.00, false, 30, 8),
    (3, 28, '2024-09-01', '2024-09-07', 7, 'HB', 800.00, 400.00, false, 40, 10),
    (4, 36, '2024-09-10', '2024-09-24', 14, 'FB', 2700.00, 1300.00, false, 30, 10),
    (1, 49, '2024-09-05', '2024-09-15', 10, 'HB', 1200.00, 700.00, true, 35, 10),
    (6, 53, '2024-08-10', '2024-08-20', 10, 'HB', 1100.00, 600.00, false, 30, 0),
    (1, 60, '2024-08-10', '2024-08-17', 7, 'HB', 1100.00, 1000.00, false, 28, 50),
    (8, 29, '2024-07-20', '2024-08-02', 14, 'HB', 2700.00, 1500.00, true, 30, 50),
    (2, 37, '2024-08-10', '2024-08-24', 14, 'HB', 1100.00, 700.00, false, 50, 0),
    (1, 52, '2024-07-10', '2024-07-17', 7, 'HB', 1500.00, 1000.00, true, 50, 20);

-- Purchases Table
INSERT INTO purchases (trip_id, adult_count, child_count, total_amount, purchase_date)
VALUES
    (1, 2, 1, 3000.00, '2024-01-01'),
    (3, 1, 0, 800.00, '2024-01-02'),
    (2, 2, 0, 1000.00, '2024-01-03'),
    (5, 1, 0, 1200.00, '2024-01-03'),
    (4, 4, 0, 6000.00, '2024-02-06');

INSERT INTO authorities (id, name)
VALUES
    ( 1, 'ADMIN' ),
    (2, 'USER');

INSERT INTO users (id, username, password, is_account_mon_expired, is_account_non_locked, is_credentials_non_expired, is_enabled)
VALUES
    (1, 'test', 'pass', true, true, true, true),
    (2, 'testuser', 'pass', false, false, false, false);

INSERT INTO user_authorities (id, user_id, authority_id)
VALUES
    (1,1,1),
    (2,2,2);

