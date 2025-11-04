
// ========== DAO (Data Access Object) ==========

import dto.Guerrier;
import dto.Mage;
import dto.Personnage;
import dto.Pretre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class PersonnageDAO {
    private Connection connection;

    public PersonnageDAO(Connection connection) {
        this.connection = connection;
    }

    // Créer un personnage
    public void creer(Personnage p) throws SQLException {
        String sql = "INSERT INTO personnages (type, nom, force_frappe, points_vie, mana, puissance_sorts, puissance_soin, armure, points_vie_max) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, p.getType());
            stmt.setString(2, p.getNom());
            stmt.setInt(3, p.getForceFrappe());
            stmt.setInt(4, p.getPointsDeVie());
            stmt.setInt(9, p.getPointsDeVieMax());

            // Attributs spécifiques selon le type
            if (p instanceof Mage) {
                Mage m = (Mage) p;
                stmt.setInt(5, m.getMana());
                stmt.setInt(6, m.getPuissanceSort());
                stmt.setNull(7, Types.INTEGER);
                stmt.setNull(8, Types.INTEGER);
            } else if (p instanceof Pretre) {
                Pretre pr = (Pretre) p;
                stmt.setInt(5, pr.getMana());
                stmt.setNull(6, Types.INTEGER);
                stmt.setInt(7, pr.getPuissanceSoin());
                stmt.setNull(8, Types.INTEGER);
            } else if (p instanceof Guerrier) {
                Guerrier g = (Guerrier) p;
                stmt.setNull(5, Types.INTEGER);
                stmt.setNull(6, Types.INTEGER);
                stmt.setNull(7, Types.INTEGER);
                stmt.setInt(8, g.getArmure());
            }

            stmt.executeUpdate();

            // Récupérer l'ID généré
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getInt(1));
                }
            }
        }
    }

    // Lire un personnage par ID
    public Personnage lire(int id) throws SQLException {
        String sql = "SELECT * FROM personnages WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return construirePersonnage(rs);
                }
            }
        }
        return null;
    }

    // Lire tous les personnages
    public List<Personnage> lireTous() throws SQLException {
        List<Personnage> personnages = new ArrayList<>();
        String sql = "SELECT * FROM personnages";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                personnages.add(construirePersonnage(rs));
            }
        }
        return personnages;
    }

    // Mettre à jour un personnage
    public void mettreAJour(Personnage p) throws SQLException {
        String sql = "UPDATE personnages SET nom = ?, force_frappe = ?, points_vie = ?, " +
                "mana = ?, puissance_sorts = ?, puissance_soin = ?, armure = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, p.getNom());
            stmt.setInt(2, p.getForceFrappe());
            stmt.setInt(3, p.getPointsDeVie());

            if (p instanceof Mage) {
                Mage m = (Mage) p;
                stmt.setInt(4, m.getMana());
                stmt.setInt(5, m.getPuissanceSort());
                stmt.setNull(6, Types.INTEGER);
                stmt.setNull(7, Types.INTEGER);
            } else if (p instanceof Pretre) {
                Pretre pr = (Pretre) p;
                stmt.setInt(4, pr.getMana());
                stmt.setNull(5, Types.INTEGER);
                stmt.setInt(6, pr.getPuissanceSoin());
                stmt.setNull(7, Types.INTEGER);
            } else if (p instanceof Guerrier) {
                Guerrier g = (Guerrier) p;
                stmt.setNull(4, Types.INTEGER);
                stmt.setNull(5, Types.INTEGER);
                stmt.setNull(6, Types.INTEGER);
                stmt.setInt(7, g.getArmure());
            }

            stmt.setInt(8, p.getId());
            stmt.executeUpdate();
        }
    }

    // Supprimer un personnage
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM personnages WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Méthode privée pour construire un personnage depuis un ResultSet
    private Personnage construirePersonnage(ResultSet rs) throws SQLException {
        String type = rs.getString("type");
        int id = rs.getInt("id");
        String nom = rs.getString("nom");
        int forceFrappe = rs.getInt("force_frappe");
        int pointsVie = rs.getInt("points_vie");

        Personnage p = null;

        switch (type) {
            case "Mage":
                int manaMage = rs.getInt("mana");
                int puissanceSorts = rs.getInt("puissance_sorts");
                p = new Mage(nom, forceFrappe, pointsVie, manaMage, puissanceSorts);
                break;
            case "Pretre":
                int manaPretre = rs.getInt("mana");
                int puissanceSoin = rs.getInt("puissance_soin");
                p = new Pretre(nom, forceFrappe, pointsVie, manaPretre, puissanceSoin);
                break;
            case "Guerrier":
                int armure = rs.getInt("armure");
                p = new Guerrier(nom, forceFrappe, pointsVie, armure);
                break;
        }

        if (p != null) {
            p.setId(id);
        }

        return p;
    }
}

