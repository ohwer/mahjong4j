package org.mahjong4j;

import org.junit.Before;
import org.junit.Test;
import org.mahjong4j.hands.MahjongHands;
import org.mahjong4j.tile.MahjongTile;
import org.mahjong4j.yaku.normals.MahjongYakuEnum;
import org.mahjong4j.yaku.yakuman.MahjongYakumanEnum;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.mahjong4j.tile.MahjongTile.*;
import static org.mahjong4j.yaku.yakuman.MahjongYakumanEnum.TENHO;

/**
 * @author yu1ro
 */
public class TenhoTest {
    private Mahjong mahjong;

    @Before
    public void setUp() throws Exception {
        int[] tiles = {
            3, 0, 0, 0, 0, 0, 0, 0, 3,
            0, 0, 0, 0, 0, 0, 1, 1, 1,
            0, 0, 2, 0, 0, 0, 0, 0, 3,
            0, 0, 0, 0,
            0, 0, 0
        };
        MahjongTile last = M6;
        MahjongHands hands = new MahjongHands(tiles, last);
        List<MahjongTile> dora = new ArrayList<>(1);
        dora.add(CHN);

        List<MahjongTile> uradora = new ArrayList<>(1);
        uradora.add(M2);
        GeneralSituation generalSituation;
        generalSituation = new GeneralSituation(true, false, TON, dora, uradora);
        PersonalSituation personalSituation;
        personalSituation = new PersonalSituation(true, true, true, false, false, false, false, NAN);

        mahjong = new Mahjong(hands, generalSituation, personalSituation);
        mahjong.calculate();
    }

    @Test
    public void testGetYakumanListSize() throws Exception {
        List<MahjongYakumanEnum> actual = mahjong.getYakumanList();

        assertEquals(1, actual.size());
    }

    @Test
    public void testGetYakumanListItem() throws Exception {
        List<MahjongYakumanEnum> actual = mahjong.getYakumanList();

        assertThat(actual, hasItems(TENHO));
    }

    @Test
    public void testGetNormalYakuListSize() throws Exception {
        List<MahjongYakuEnum> actual = mahjong.getNormalYakuList();

        assertEquals(0, actual.size());
    }
}
