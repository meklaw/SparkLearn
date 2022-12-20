package org.example

import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    print("Starting...")

    val spark = SparkSession.builder()
      .appName("Hello spark app")
      .master("local")
      .getOrCreate()

    val df = spark.read.format("csv")
      .option("header", "true")
      .load("data/helo.csv")

    df.show(2)

    spark.stop()
  }
}
