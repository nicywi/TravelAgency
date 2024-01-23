-- Continent Table
INSERT INTO continent (name) VALUES ('Europe');
INSERT INTO continent (name) VALUES ('Asia');
INSERT INTO continent (name) VALUES ('Africa');
INSERT INTO continent (name) VALUES ('North America');
INSERT INTO continent (name) VALUES ('South America');

-- Country Table
INSERT INTO country (name, continent_id) VALUES ('Poland', 1);
INSERT INTO country (name, continent_id) VALUES ('Italy', 1);
INSERT INTO country (name, continent_id) VALUES ('France', 1);
INSERT INTO country (name, continent_id) VALUES ('Switzerland', 1);
INSERT INTO country (name, continent_id) VALUES ('Austria', 1);
INSERT INTO country (name, continent_id) VALUES ('Germany', 1);

-- City Tables
-- City Table for Poland
INSERT INTO city (name, country_id) VALUES
                                        ('Warsaw', 1), ('Karkow', 1), ('Wroclaw', 1), ('Zakopane', 1), ('Poznan', 1),
                                        ('Gdansk', 1), ('Torun', 1), ('Szczecin', 1), ('Gdynia', 1), ('Katowice', 1);

-- City Table for Italy
INSERT INTO city (name, country_id) VALUES
                                        ('Rome', 2), ('Milan', 2), ('Florence', 2), ('Venice', 2), ('Naples', 2),
                                        ('Turin', 2), ('Bologna', 2), ('Genoa', 2), ('Bari', 2), ('Palermo', 2);
-- City Table for France
INSERT INTO city (name, country_id) VALUES
                                        ('Paris', 3), ('Marseille', 3), ('Lyon', 3), ('Toulouse', 3), ('Nice', 3),
                                        ('Nantes', 3), ('Strasbourg', 3), ('Montpellier', 3), ('Bordeaux', 3), ('Lille', 3);
-- City Table for Switzerland
INSERT INTO city (name, country_id) VALUES
                                        ('Zurich', 4), ('Geneva', 4), ('Basel', 4), ('Bern', 4), ('Lausanne', 4),
                                        ('Lucerne', 4), ('St. Moritz', 4), ('Interlaken', 4), ('Lugano', 4), ('Zermatt', 4);
-- City Table for Austria
INSERT INTO city (name, country_id) VALUES
                                        ('Vienna', 5), ('Salzburg', 5), ('Innsbruck', 5), ('Graz', 5), ('Linz', 5),
                                        ('Klagenfurt', 5), ('Bregenz', 5), ('St. Anton am Arlberg', 5), ('Hallstatt', 5), ('Eisenstadt', 5);
-- City Table for Germany
INSERT INTO city (name, country_id) VALUES
                                        ('Berlin', 6), ('Munich', 6), ('Hamburg', 6), ('Cologne', 6), ('Frankfurt', 6),
                                        ('Stuttgart', 6), ('Dresden', 6), ('Leipzig', 6), ('Nuremberg', 6), ('Heidelberg', 6);


-- Airport Tables
-- Airport Table for Poland
INSERT INTO airport (name, city_id) VALUES
                                        ('Warsaw Chopin Airport', 1), ('Krakow International Airport', 2), ('Wroclaw Nicolaus Copernicus Airport', 3),
                                        ('Zakopane Airport', 4), ('Poznan–Ławica Airport', 5), ('Gdansk Lech Walesa Airport', 6),
                                        ('Torun Airport', 7), ('Szczecin-Goleniow "Solidarnosc" Airport', 8), ('Gdynia-Kosakowo Airport', 9),
                                        ('Katowice Airport', 10);

-- Airport Table for Italy
INSERT INTO airport (name, city_id) VALUES
                                        ('Leonardo da Vinci-Fiumicino Airport', 11), ('Malpensa Airport', 12), ('Peretola Airport', 13),
                                        ('Marco Polo Airport', 14), ('Capodichino Airport', 15), ('Turin Airport', 16),
                                        ('Guglielmo Marconi Airport', 17), ('Cristoforo Colombo Airport', 18), ('Bari Karol Wojtyła Airport', 19),
                                        ('Falcone-Borsellino Airport', 20);

-- Airport Table for France
INSERT INTO airport (name, city_id) VALUES
                                        ('Charles de Gaulle Airport', 21), ('Marseille Provence Airport', 22), ('Lyon-Saint-Exupéry Airport', 23),
                                        ('Toulouse-Blagnac Airport', 24), ('Nice Côte dAzur Airport', 25), ('Nantes Atlantique Airport', 26),
                                        ('Strasbourg Airport', 27), ('Montpellier-Méditerranée Airport', 28), ('Bordeaux-Mérignac Airport', 29),
                                        ('Lille Airport', 30);
-- Airport Table for Switzerland
INSERT INTO airport (name, city_id) VALUES
                                        ('Zurich Airport', 31), ('Geneva Airport', 32), ('EuroAirport Basel-Mulhouse-Freiburg', 33),
                                        ('Bern Airport', 34), ('Lausanne Airport', 35), ('Lucerne Airport', 36),
                                        ('Engadin Airport', 37), ('Interlaken Airport', 38), ('Lugano Airport', 39), ('Zermatt Airport', 40);

-- Airport Table for Austria
INSERT INTO airport (name, city_id) VALUES
                                        ('Vienna International Airport', 41), ('Salzburg Airport', 42), ('Innsbruck Airport', 43),
                                        ('Graz Airport', 44), ('Linz Airport', 45), ('Klagenfurt Airport', 46),
                                        ('Bregenz Airport', 47), ('St. Anton am Arlberg Airport', 48), ('Salzkammergut Airport', 49), ('Eisenstadt Airport', 50);

-- Airport Table for Germany
INSERT INTO airport (name, city_id) VALUES
                                        ('Berlin Brandenburg Airport', 51), ('Munich Airport', 52), ('Hamburg Airport', 53),
                                        ('Cologne Bonn Airport', 54), ('Frankfurt Airport', 55), ('Stuttgart Airport', 56),
                                        ('Dresden Airport', 57), ('Leipzig/Halle Airport', 58), ('Nuremberg Airport', 59), ('Heidelberg Airport', 60);
