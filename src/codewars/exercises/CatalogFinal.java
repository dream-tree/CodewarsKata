package codewars.exercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// test cases show that looking for 'saw' should give such results: 'saw', 'saw for metal", "cine saw" etc.

public class CatalogFinal {

    public static void main(String[] args) {
        String s =
                "<prod><name>drill</name><prx>99</prx><qty>5</qty></prod>\n\n" +
                        "<prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>\n\n" +
                        "<prod><name>screwdriver</name><prx>5</prx><qty>51</qty></prod>\n\n" +
                        "<prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>\n\n" +
                        "<prod><name>saw</name><prx>9</prx><qty>10</qty></prod>\n\n" +
                        "<prod><name>chair</name><prx>100</prx><qty>20</qty></prod>\n\n" +
                        "<prod><name>fan</name><prx>50</prx><qty>8</qty></prod>\n\n" +
                        "<prod><name>wire</name><prx>10.8</prx><qty>15</qty></prod>\n\n" +
                        "<prod><name>battery</name><prx>150</prx><qty>12</qty></prod>\n\n" +
                        "<prod><name>pallet</name><prx>10</prx><qty>50</qty></prod>\n\n" +
                        "<prod><name>wheel</name><prx>8.80</prx><qty>32</qty></prod>\n\n" +
                        "<prod><name>extractor</name><prx>105</prx><qty>17</qty></prod>\n\n" +
                        "<prod><name>bumper</name><prx>150</prx><qty>3</qty></prod>\n\n" +
                        "<prod><name>ladder</name><prx>112</prx><qty>12</qty></prod>\n\n" +
                        "<prod><name>hoist</name><prx>13.80</prx><qty>32</qty></prod>\n\n" +
                        "<prod><name>platform</name><prx>65</prx><qty>21</qty></prod>\n\n" +
                        "<prod><name>car wheel</name><prx>505</prx><qty>7</qty></prod>\n\n" +
                        "<prod><name>bicycle wheel</name><prx>150</prx><qty>11</qty></prod>\n\n" +
                        "<prod><name>big hammer</name><prx>18</prx><qty>12</qty></prod>\n\n" +
                        "<prod><name>saw for metal</name><prx>13.80</prx><qty>32</qty></prod>\n\n" +
                        "<prod><name>wood pallet</name><prx>65</prx><qty>21</qty></prod>\n\n" +
                        "<prod><name>circular fan</name><prx>80</prx><qty>8</qty></prod>\n\n" +
                        "<prod><name>exhaust fan</name><prx>62</prx><qty>8</qty></prod>\n\n" +
                        "<prod><name>cattle prod</name><prx>990</prx><qty>2</qty></prod>\n\n" +
                        "<prod><name>window fan</name><prx>62</prx><qty>8</qty></prod>";
        System.out.println(catalog(s, "saw"));
    }

    public static String catalog(String text, String article) {
        text = text.replaceAll("/", "");
        text = text.replaceAll("\n", "");
        String extendedArticleDescription = "(\\w*\\s*" + article + "\\s*\\w*\\s*\\w*)";
        String patternString = "<prod><name>" + extendedArticleDescription +
                "<name><prx>([0-9]+[.])?([0-9]+)<prx><qty>(\\w+)<qty><prod>";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        String result = "";

        while (matcher.find()) {
            String correctedArticle = matcher.group(1);
            String priceIntegerPart = matcher.group(2);
            String priceFractionalPart = matcher.group(3);
            String quantity = matcher.group(4);
            String price = priceIntegerPart == null ? priceFractionalPart
                    : priceIntegerPart + priceFractionalPart;
            result += String.format("%s > prx: $%s qty: %s%n", correctedArticle, price, quantity);
        }
        return result.equals("") ?  "Nothing" : result.substring(0, result.length() - 1);
    }
}