import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertTrue;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    //이충희
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<Champion> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    //notNullValue 활용한 테스트
    //by 황재완
    @Test
    public void notNullCheck() {
        String lpl = "LPL";
        assertThat(lpl, notNullValue());
    }

    //nullValue 활용한 테스트
    //by 이충희
    @Test
    public void givenStringWhenNullIsCorrect() {
        String LPL= null;
        assertThat(LPL, nullValue());
    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    //by 황재완
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Republic of Korea";
        String sampleString2 = "The United States of America";
        String startString = "Republic";
        String endString = "America";
        assertThat(sampleString1, endsWith("Korea"));
        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleString2, allOf(startsWith("The"), endsWith("America")));
        assertThat(sampleString2, is(containsString(endString)));
//        assertThat(sampleString2, is(endsWith(endString)));
    }

    //부동소수점 범위 closeTo 테스트
    //이충희
    @Test
    public void testForFloatingPoint() {
        assertThat(1321.00, closeTo(1000, 500.0));
    }


    //anything 테스트
    //by 황재완
    @Test
    public void shouldNotErrorGetReference() {
        assertThat(championList.get(4), anything()); //값만 가져올 수 있다면 true
        assertThat(championList.get(4).getName(), anything());
//        assertThat(championList.get(2), anything());
    }

    //객체 크기 검증 테스트 hasSize
    //이충희
    @Test
    public void shouldChampionCountFive() {
        championList.add(new Champion("티버","유사챔피언"));
        assertTrue(championList.size() == 6);
        assertThat(championList.size(), is(6));
        assertThat(championList, hasSize(6));
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    //by 황재완
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", equalTo(supportChamp.getName()));
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    //이충희
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(0), hasProperty("name"));
        assertThat(championList.get(1), hasProperty("name", equalTo("리신")));
    }
    //hasToString 활용 테스트
    //by 황재완
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "조이", "갈리오", "모르가나", "블라디미르");
        assertThat(champListNames.get(0), hasToString("루시안"));
        assertThat(champListNames.get(1), hasToString("애쉬"));
        assertThat(champListNames.get(3), hasToString("갈리오"));
    }

    //property와 value가 같은지 테스트
    //이충희
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("갱플랭크", "세주아니", "카이사", "가렌", "케일", "볼리베어");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames1, samePropertyValuesAs(championNames2));
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    //by 황재완
    @Test
    public void shouldTopChampionIsDarius() {
//        Optional<Champion> filteredChampion  = championList.stream()
//                .filter(c->c.getPosition().equals("바텀"))
//                .findFirst();
//        String champName = filteredChampion.get().getName();
//        assertThat("베인",is(champName));

        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst();
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));
    }

    //sameInstance 테스트
    //by 황재완
    @Test
    public void testIsTheSameInstance() {
        Champion champion1 = new Champion("야스오","미드");
        Champion champion2 = champion1;
        assertThat(champion1, sameInstance(champion2));

    }

    //hasItem 테스트
    //by 황재완
    @Test
    public void testHasItem() {
        assertThat(championList, hasItem(hasProperty("position", is("정글"))));
    }
    //lessThan테스트
    //by이충희
    @Test
    public void 챔피언의숫자는8개보다적어야한다(){
        assertThat(championList.size(),lessThan(8));

    }
    //instanceof 테스트
    //이충희
    @Test
    public void 챔피언리스트는챔피언클래스로이루어져야한다(){
        assertThat(championList.get(0),instanceOf(Champion.class));
    }

}