

 /*
 * CombatGroup.java
 *
 * Created on Feb 10, 2010, 3:36:55 PM
 */
package mage.client.unusedFiles;

//package mage.client.game;
import java.util.UUID;
import mage.client.cards.BigCard;
import mage.client.util.Config;
import mage.client.util.GUISizeHelper;
import mage.view.CombatGroupView;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class CombatGroup extends javax.swing.JPanel {

    private UUID gameId;
    private BigCard bigCard;

    /**
     * Creates new form CombatGroup
     */
    public CombatGroup() {
        initComponents();
        attackers.setDontDisplayTapped(true);
    }

    public void init(UUID gameId, BigCard bigCard) {
        this.gameId = gameId;
        this.bigCard = bigCard;
    }

    public void update(CombatGroupView combatGroup) {
        this.lblDefender.setText(combatGroup.getDefenderName());
        attackers.setCardDimension(GUISizeHelper.otherZonesCardDimension);
        this.attackers.loadCards(combatGroup.getAttackers(), bigCard, gameId, true);

        blockers.setCardDimension(GUISizeHelper.otherZonesCardDimension);
        this.blockers.loadCards(combatGroup.getBlockers(), bigCard, gameId, true);

        this.attackers.setVisible(true);
        this.blockers.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blockers = new mage.client.cards.Cards();
        attackers = new mage.client.cards.Cards();
        lblDefender = new javax.swing.JLabel();

        blockers.setPreferredSize(new java.awt.Dimension(Config.dimensions.frameWidth + 8, Config.dimensions.frameHeight + 25));

        attackers.setPreferredSize(new java.awt.Dimension(Config.dimensions.frameWidth + 8, Config.dimensions.frameHeight + 25));

        lblDefender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDefender.setText("Defender");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDefender, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
            .addComponent(blockers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(attackers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblDefender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blockers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(attackers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mage.client.cards.Cards attackers;
    private mage.client.cards.Cards blockers;
    private javax.swing.JLabel lblDefender;
    // End of variables declaration//GEN-END:variables

}
