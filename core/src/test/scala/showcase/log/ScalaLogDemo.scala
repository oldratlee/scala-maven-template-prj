package showcase.log

import com.typesafe.scalalogging.StrictLogging

object ScalaLogDemo extends StrictLogging {
  def main(args: Array[String]): Unit = {
    logger.info(s"Hello scala logger, ${System.getProperty("user.name")}!")
  }
}
