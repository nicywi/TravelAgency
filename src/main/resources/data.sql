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
-- INSERT INTO trips (departure_city_id, destination_city_id, start_date, end_date, duration_days, meal_type, price_adult, price_child, promoted, available_adult_seats, available_child_seats)
-- VALUES (1, 2, '2024-02-01', '2024-02-10', 10, 'AI', 1200.00, 600.00, true, 50, 20);