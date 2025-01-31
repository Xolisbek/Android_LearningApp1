package uz.kholisbek.myaplicationforlearning.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Questions {
    private static ArrayList<TestVariant> questions;
    private static Gson gson;

    private static String data;

    private Questions() {
    }

    private static void setQuestions() {
        Type type = new TypeToken<ArrayList<TestVariant>>() {
        }.getType();

        questions = gson.fromJson(getData(), type);
    }

    private static String getData() {
        if (data == null) {
            data = "[\n" +
                    "    {\n" +
                    "        \"question\": \"What is the correct form of the verb in the following sentence? The cat ___ sleeping on the mat.\",\n" +
                    "        \"variantA\": \"are\",\n" +
                    "        \"variantB\": \"am\",\n" +
                    "        \"variantC\": \"is\",\n" +
                    "        \"variantD\": \"be\",\n" +
                    "        \"answer\": \"is\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"question\": \"Which pronoun is used to refer to a group of people?\",\n" +
                    "        \"variantA\": \"it\",\n" +
                    "        \"variantB\": \"they\",\n" +
                    "        \"variantC\": \"he\",\n" +
                    "        \"variantD\": \"she\",\n" +
                    "        \"answer\": \"they\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"question\": \"What is the plural form of 'child'?\",\n" +
                    "        \"variantA\": \"childs\",\n" +
                    "        \"variantB\": \"childes\",\n" +
                    "        \"variantC\": \"childrens\",\n" +
                    "        \"variantD\": \"children\",\n" +
                    "        \"answer\": \"children\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"question\": \"Which of the following is a preposition?\",\n" +
                    "        \"variantA\": \"jump\",\n" +
                    "        \"variantB\": \"with\",\n" +
                    "        \"variantC\": \"happy\",\n" +
                    "        \"variantD\": \"quickly\",\n" +
                    "        \"answer\": \"with\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"question\": \"Choose the correct past tense of the verb 'go'.\",\n" +
                    "        \"variantA\": \"goed\",\n" +
                    "        \"variantB\": \"go\",\n" +
                    "        \"variantC\": \"gone\",\n" +
                    "        \"variantD\": \"goeded\",\n" +
                    "        \"answer\": \"gone\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"question\": \"Which sentence is in the present perfect tense?\",\n" +
                    "        \"variantA\": \"I will go to the store.\",\n" +
                    "        \"variantB\": \"I went to the store.\",\n" +
                    "        \"variantC\": \"I have gone to the store.\",\n" +
                    "        \"variantD\": \"I go to the store.\",\n" +
                    "        \"answer\": \"I have gone to the store.\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"question\": \"Identify the noun in the following sentence: The sun shines brightly.\",\n" +
                    "        \"variantA\": \"shines\",\n" +
                    "        \"variantB\": \"brightly\",\n" +
                    "        \"variantC\": \"the\",\n" +
                    "        \"variantD\": \"sun\",\n" +
                    "        \"answer\": \"sun\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"question\": \"What is the comparative form of the adjective 'big'?\",\n" +
                    "        \"variantA\": \"bigger\",\n" +
                    "        \"variantB\": \"biger\",\n" +
                    "        \"variantC\": \"big\",\n" +
                    "        \"variantD\": \"biggest\",\n" +
                    "        \"answer\": \"bigger\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"question\": \"Which sentence is written in the passive voice?\",\n" +
                    "        \"variantA\": \"The cat chased the mouse.\",\n" +
                    "        \"variantB\": \"The mouse was chased by the cat.\",\n" +
                    "        \"variantC\": \"The mouse chased the cat.\",\n" +
                    "        \"variantD\": \"The cat was chasing the mouse.\",\n" +
                    "        \"answer\": \"The mouse was chased by the cat.\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"question\": \"Select the correct possessive pronoun: This book belongs to (we/us).\",\n" +
                    "        \"variantA\": \"we\",\n" +
                    "        \"variantB\": \"our\",\n" +
                    "        \"variantC\": \"us\",\n" +
                    "        \"variantD\": \"ours\",\n" +
                    "        \"answer\": \"ours\"\n" +
                    "    }\n" +
                    "]\n";
        }
        return data;
    }

    public static ArrayList<TestVariant> getQuestions() {
        if (questions == null) {
            questions = new ArrayList<>();
            gson = new Gson();
            setQuestions();
        }
        return questions;
    }

}
