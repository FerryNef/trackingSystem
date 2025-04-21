-- Insert satellites
INSERT INTO satellite (id, name, launch_date, orbit_type, decommissioned)
VALUES (1, 'Hubble', '1990-04-24', 'LEO', FALSE);

INSERT INTO satellite (id, name, launch_date, orbit_type, decommissioned)
VALUES (2, 'Starlink-17', '2023-08-14', 'MEO', FALSE);

INSERT INTO satellite (id, name, launch_date, orbit_type, decommissioned)
VALUES (3, 'Sentinel-6', '2020-11-21', 'LEO', TRUE);

-- Insert astronauts
INSERT INTO astronaut (id, first_name, last_name, experience_years)
VALUES (1, 'Neil', 'Armstrong', 12);

INSERT INTO astronaut (id, first_name, last_name, experience_years)
VALUES (2, 'Sally', 'Ride', 8);

INSERT INTO astronaut (id, first_name, last_name, experience_years)
VALUES (3, 'Chris', 'Hadfield', 15);

-- Associate astronauts and satellites
INSERT INTO astronaut_satellite (astronaut_id, satellite_id) VALUES (1, 1); -- Neil -> Hubble
INSERT INTO astronaut_satellite (astronaut_id, satellite_id) VALUES (2, 2); -- Sally -> Starlink-17
INSERT INTO astronaut_satellite (astronaut_id, satellite_id) VALUES (3, 1); -- Chris -> Hubble
INSERT INTO astronaut_satellite (astronaut_id, satellite_id) VALUES (3, 2); -- Chris -> Starlink-17
