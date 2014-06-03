/*
 * Copyright 2014 Julian Peeters
 *   
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.julianpeeters.avro.annotations._

import org.apache.avro.specific._
import org.apache.avro.generic._
import org.apache.avro.file._

import java.io.File

@AvroRecord
case class MyRecord(var i: Int, var j: Int)

object Example extends App {
val record = MyRecord(4, 8)
  println(record.getSchema)

  val file = File.createTempFile("record", "avro")
    file.deleteOnExit()

  val userDatumWriter = new SpecificDatumWriter[MyRecord]
  val dataFileWriter = new DataFileWriter[MyRecord](userDatumWriter)
    dataFileWriter.create(record.getSchema(), file);
    dataFileWriter.append(record);
    dataFileWriter.close();

  val schema = new DataFileReader(file, new GenericDatumReader[GenericRecord]).getSchema
  val userDatumReader = new SpecificDatumReader[MyRecord](schema)
  val dataFileReader = new DataFileReader[MyRecord](file, userDatumReader)
  val sameRecord = dataFileReader.next()
  
  println("deserialized record is the same as the pre-serialized record?: " + (sameRecord == record) )
 
}
