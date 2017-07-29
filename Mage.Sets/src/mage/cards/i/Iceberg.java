/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.cards.i;

import java.util.UUID;
import mage.Mana;
import mage.abilities.common.EntersBattlefieldAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.RemoveCountersSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.EntersBattlefieldWithXCountersEffect;
import mage.abilities.effects.common.counter.AddCountersSourceEffect;
import mage.abilities.mana.SimpleManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Zone;
import mage.counters.CounterType;

/**
 *
 * @author TheElk801
 */
public class Iceberg extends CardImpl {

    public Iceberg(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ENCHANTMENT}, "{X}{U}{U}");

        // Iceberg enters the battlefield with X ice counters on it.
        this.addAbility(new EntersBattlefieldAbility(new EntersBattlefieldWithXCountersEffect(CounterType.ICE.createInstance())));

        // {3}: Put an ice counter on Iceberg.
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD, new AddCountersSourceEffect(CounterType.ICE.createInstance(1)), new ManaCostsImpl("{3}")));

        // Remove an ice counter from Iceberg: Add {C} to your mana pool.
        this.addAbility(new SimpleManaAbility(Zone.BATTLEFIELD, Mana.ColorlessMana(1), new RemoveCountersSourceCost(CounterType.ICE.createInstance(1))));
    }

    public Iceberg(final Iceberg card) {
        super(card);
    }

    @Override
    public Iceberg copy() {
        return new Iceberg(this);
    }
}