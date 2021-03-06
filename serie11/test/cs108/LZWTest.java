package cs108;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LZWTest {
    public LZWEncoder newEncoder(SortedSet<Character> alphabet, int dictCapacity) {
       return new LZWConcreteEncoder(alphabet, dictCapacity);
    }

    public LZWDecoder newDecoder(SortedSet<Character> alphabet, int dictCapacity) {
        return new LZWConcreteDecoder(alphabet, dictCapacity);
    }

    private static SortedSet<Character> stringToSet(String s) {
        SortedSet<Character> set = new TreeSet<>();
        for (int i = 0; i < s.length(); ++i)
            set.add(s.charAt(i));
        return set;
    }

    @Test
    public void encoderCorrectlyEncodesEmptyString() {
        LZWEncoder e = newEncoder(Collections.emptySortedSet(), 10);
        assertTrue(e.encode("").isEmpty());
    }

    @Test
    public void encoderCorrectlyEncodesExample() {
        SortedSet<Character> alphabet = new TreeSet<>(Set.of('a', 'b', 'e', 'n'));
        String str = "bananebabaane";
        LZWEncoder e = newEncoder(alphabet, 8);
        assertEquals(List.of(1, 0, 3, 5, 2, 4, 4, 7), e.encode(str));
    }

    @Test
    public void decoderCorrectlyDecodesEmptyList() {
        LZWDecoder d = newDecoder(Collections.emptySortedSet(), 10);
        assertEquals("", d.decode(List.of()));
    }

    @Test
    public void decoderCorrectlyDecodesExample() {
        SortedSet<Character> alphabet = new TreeSet<>(Set.of('a', 'b', 'e', 'n'));
        LZWDecoder d = newDecoder(alphabet, 8);
        List<Integer> compressed = List.of(1, 0, 3, 5, 2, 4, 4, 7);
        assertEquals("bananebabaane", d.decode(compressed));
    }

    @Test
    public void decoderCorrectlyHandlesTrickyCase() {
        SortedSet<Character> alphabet = new TreeSet<>(Set.of('a'));
        LZWDecoder d = newDecoder(alphabet, 2);
        List<Integer> compressed = List.of(0, 1);
        assertEquals("aaa", d.decode(compressed));
    }

    @Test
    public void repeatedSequenceIsCorrectlyEncodedAndDecoded() {
        SortedSet<Character> alphabet = new TreeSet<>(Set.of('a'));
        int dictCapacity = 128;
        LZWEncoder e = newEncoder(alphabet, dictCapacity);
        LZWDecoder d = newDecoder(alphabet, dictCapacity);
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        assertEquals(s, d.decode(e.encode(s)));
    }

    @Test
    public void candideIsCorrectlyCompressedAndDecompressed() {
        String candide = "Il y avait en Vestphalie, dans le ch??teau de M. le "
                + "baron de Thunder-ten-tronckh, un jeune gar??on ?? qui la "
                + "nature avait donn?? les moeurs les plus douces. Sa "
                + "physionomie annon??ait son ??me. Il avait le jugement "
                + "assez droit, avec l'esprit le plus simple; c'est, je "
                + "crois, pour cette raison qu'on le nommait Candide. Les "
                + "anciens domestiques de la maison soup??onnaient qu'il "
                + "??tait fils de la soeur de monsieur le baron et d'un bon "
                + "et honn??te gentilhomme du voisinage, que cette "
                + "demoiselle ne voulut jamais ??pouser parce qu'il n'avait "
                + "pu prouver que soixante et onze quartiers, et que le "
                + "reste de son arbre g??n??alogique avait ??t?? perdu par "
                + "l'injure du temps. Monsieur le baron ??tait un des plus "
                + "puissants seigneurs de la Westphalie, car son ch??teau "
                + "avait une porte et des fen??tres. Sa grande salle m??me "
                + "??tait orn??e d'une tapisserie. Tous les chiens de ses "
                + "basses-cours composaient une meute dans le besoin; ses "
                + "palefreniers ??taient ses piqueurs; le vicaire du "
                + "village ??tait son grand-aum??nier. Ils l'appelaient tous "
                + "monseigneur, et ils riaient quand il fesait des contes. "
                + "Madame la baronne, qui pesait environ trois cent "
                + "cinquante livres, s'attirait par l?? une tr??s grande "
                + "consid??ration, et fesait les honneurs de la maison avec "
                + "une dignit?? qui la rendait encore plus respectable. Sa "
                + "fille Cun??gonde, ??g??e de dix-sept ans, ??tait haute en "
                + "couleur, fra??che, grasse, app??tissante. Le fils du "
                + "baron paraissait en tout digne de son p??re. Le "
                + "pr??cepteur Pangloss ??tait l'oracle de la maison, et le "
                + "petit Candide ??coutait ses le??ons avec toute la bonne "
                + "foi de son ??ge et de son caract??re. Pangloss enseignait "
                + "la m??taphysico-th??ologo-cosmolonigologie. Il prouvait "
                + "admirablement qu'il n'y a point d'effet sans cause, et "
                + "que, dans ce meilleur des mondes possibles, le ch??teau "
                + "de monseigneur le baron ??tait le plus beau des "
                + "ch??teaux, et madame la meilleure des baronnes "
                + "possibles. Il est d??montr??, disait-il, que les choses "
                + "ne peuvent ??tre autrement; car tout ??tant fait pour une "
                + "fin, tout est n??cessairement pour la meilleure fin. "
                + "Remarquez bien que les nez ont ??t?? faits pour porter "
                + "des lunettes; aussi avons-nous des lunettes. Les jambes "
                + "sont visiblement institu??es pour ??tre chauss??es, et "
                + "nous avons des chausses. Les pierres ont ??t?? form??es "
                + "pour ??tre taill??es et pour en faire des ch??teaux; aussi "
                + "monseigneur a un tr??s beau ch??teau: le plus grand baron "
                + "de la province doit ??tre le mieux log??; et les cochons "
                + "??tant faits pour ??tre mang??s, nous mangeons du porc "
                + "toute l'ann??e: par cons??quent, ceux qui ont avanc?? que "
                + "tout est bien ont dit une sottise; il fallait dire que "
                + "tout est au mieux. Candide ??coutait attentivement, et "
                + "croyait innocemment; car il trouvait mademoiselle "
                + "Cun??gonde extr??mement belle, quoiqu'il ne pr??t jamais "
                + "la hardiesse de le lui dire. Il concluait qu'apr??s le "
                + "bonheur d'??tre n?? baron de Thunder-ten-tronckh, le "
                + "second degr?? de bonheur ??tait d'??tre mademoiselle "
                + "Cun??gonde; le troisi??me, de la voir tous les jours; et "
                + "le quatri??me, d'entendre ma??tre Pangloss, le plus grand "
                + "philosophe de la province, et par cons??quent de toute "
                + "la terre. Un jour Cun??gonde, en se promenant aupr??s du "
                + "ch??teau, dans le petit bois qu'on appelait parc, vit "
                + "entre des broussailles le docteur Pangloss qui donnait "
                + "une le??on de physique exp??rimentale ?? la femme de "
                + "chambre de sa m??re, petite brune tr??s jolie et tr??s "
                + "docile. Comme mademoiselle Cun??gonde avait beaucoup de "
                + "disposition pour les sciences, elle observa, sans "
                + "souffler, les exp??riences r??it??r??es dont elle fut "
                + "t??moin; elle vit clairement la raison suffisante du "
                + "docteur, les effets et les causes, et s'en retourna "
                + "tout agit??e, toute pensive, toute remplie du d??sir "
                + "d'??tre savante, songeant qu'elle pourrait bien ??tre la "
                + "raison suffisante du jeune Candide, qui pouvait aussi "
                + "??tre la sienne. Elle rencontra Candide en revenant au "
                + "ch??teau, et rougit: Candide rougit aussi . Elle lui dit "
                + "bonjour d'une voix entrecoup??e; et Candide lui parla "
                + "sans savoir ce qu'il disait. Le lendemain, apr??s le "
                + "d??ner, comme on sortait de table, Cun??gonde et Candide "
                + "se trouv??rent derri??re un paravent; Cun??gonde laissa "
                + "tomber son mouchoir, Candide le ramassa; elle lui prit "
                + "innocemment la main; le jeune homme baisa innocemment "
                + "la main de la jeune demoiselle avec une vivacit??, une "
                + "sensibilit??, une gr??ce toute particuli??re; leurs "
                + "bouches se rencontr??rent, leurs yeux s'enflamm??rent, "
                + "leurs genoux trembl??rent, leurs mains s'??gar??rent. M. "
                + "le baron de Thunder-ten-tronckh passa aupr??s du "
                + "paravent, et voyant cette cause et cet effet, chassa "
                + "Candide du ch??teau ?? grands coups de pied dans le "
                + "derri??re. Cun??gonde s'??vanouit: elle fut soufflet??e par "
                + "madame la baronne d??s qu'elle fut revenue ?? elle-m??me; "
                + "et tout fut constern?? dans le plus beau et le plus "
                + "agr??able des ch??teaux possibles.";
        SortedSet<Character> alphabet = stringToSet(candide);
        int dictCapacity = 1024;
        for (int i = 0; i <= candide.length(); i += 5) {
            String s = candide.substring(0, i);
            LZWEncoder e = newEncoder(alphabet, dictCapacity);
            LZWDecoder d = newDecoder(alphabet, dictCapacity);

            assertEquals(s, d.decode(e.encode(s)));
        }
    }
}
