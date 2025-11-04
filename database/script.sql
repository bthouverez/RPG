DROP TABLE IF EXISTS personnages;
CREATE TABLE personnages (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             type VARCHAR(20) NOT NULL, -- 'dto.Mage', 'dto.Pretre', 'dto.Guerrier'
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
('dto.Mage', 'Gandalf', 15, 100, 100, 200, 30, NULL, NULL),
('dto.Pretre', 'Elrond', 10, 120, 120, 150, NULL, 25, NULL),
('dto.Guerrier', 'Aragorn', 25, 150, 150, NULL, NULL, NULL, 20),
('dto.Mage', 'Saruman', 18, 90, 90, 220, 35, NULL, NULL),
('dto.Pretre', 'Galadriel', 12, 110, 110, 160, NULL, 30, NULL),
('dto.Guerrier', 'Boromir', 28, -140, 140, NULL, NULL, NULL, 25),
('dto.Mage', 'Radagast', 14, 95, 95, 180, 28, NULL, NULL),
('dto.Pretre', 'Cirdan', 11, 115, 115, 155, NULL, 27, NULL),
('dto.Guerrier', 'Faramir', 26, 130, 130, NULL, NULL, NULL, 22),
('dto.Mage', 'Alatar', 16, 105, 105, 210, 32, NULL, NULL),
('dto.Pretre', 'Pallando', 13, 125, 125, 165, NULL, 29, NULL),
('dto.Guerrier', 'Thorin', 30, 160, 160, NULL, NULL, NULL, 30);