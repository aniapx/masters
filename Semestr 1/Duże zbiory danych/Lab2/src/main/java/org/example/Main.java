package org.example;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class Main {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("")
                .setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);
        // Wczytanie pliku CSV jako kolekcji linii tekstowych
        JavaRDD<String> ratings = sc.textFile("ratings.csv");
        // Zmapowanie kolekcji z liniami tekstu na kolekcję z tablic wartości rozbitych wg symbolu przecinka
        JavaRDD<String[]> ratingsArrays = ratings.map(r -> r.split(","));
        // Zmapowanie kolekcji z tablicami wartości tekstowych na kolekcję dwójek klucz-wartość (id filmu, 1)
        JavaPairRDD<String, Integer> pairs = ratingsArrays.mapToPair(w -> new Tuple2<>(w[1], 1));
        // Zredukowanie kolekcji dwójek wg klucza (id filmu) w taki sposób, aby przy każdej redukcji elementów o takim samym kluczu liczona była suma ich wartości
        JavaPairRDD<String,Integer> counts = pairs.reduceByKey((a, b) -> a + b);
        // Odwrócenie kolejności klucz-wartość.
        JavaPairRDD<Integer, String> invCounts = counts.mapToPair(x -> x.swap());
        // Posortowanie kolekcji wynikowej wg klucza
        JavaPairRDD<Integer, String> sorted = invCounts.sortByKey(false);
        sorted.foreach(e -> System.out.println(e));
    }
}
