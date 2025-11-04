DROP TABLE IF EXISTS personnages;
CREATE TABLE personnages (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             type VARCHAR(20) NOT NULL, -- 'Mage', 'Pretre', 'Guerrier'
                             nom VARCHAR(100) NOT NULL,
                             force_frappe INT NOT NULL,
                             points_vie INT NOT NULL,
                             points_vie_max INT NOT NULL,
    -- Attributs spécifiques (NULL selon le type)
                             mana INT NULL,
                             puissance_sorts INT NULL,
                             puissance_soin INT NULL,
                             armure INT NULL
);

INSERT INTO personnages (type, nom, force_frappe, points_vie, points_vie_max, mana, puissance_sorts, puissance_soin, armure)
VALUES
('Mage', 'Gandalf', 15, 100, 100, 200, 30, NULL, NULL),
('Pretre', 'Elrond', 10, 120, 120, 150, NULL, 25, NULL),
('Guerrier', 'Aragorn', 25, 150, 150, NULL, NULL, NULL, 20),
('Mage', 'Saruman', 18, 90, 90, 220, 35, NULL, NULL),
('Pretre', 'Galadriel', 12, 110, 110, 160, NULL, 30, NULL),
('Guerrier', 'Boromir', 28, 140, 140, NULL, NULL, NULL, 25),
('Mage', 'Radagast', 14, 95, 95, 180, 28, NULL, NULL),
('Pretre', 'Cirdan', 11, 115, 115, 155, NULL, 27, NULL),
('Guerrier', 'Faramir', 26, 130, 130, NULL, NULL, NULL, 22),
('Mage', 'Alatar', 16, 105, 105, 210, 32, NULL, NULL),
('Pretre', 'Pallando', 13, 125, 125, 165, NULL, 29, NULL),
('Guerrier', 'Thorin', 30, 160, 160, NULL, NULL, NULL, 30);