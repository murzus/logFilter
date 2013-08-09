



  Calendar start = new GregorianCalendar()                         
begin = start.time
  input = new File('C:/dev/distr/process_logs_v2/log/os-0371/temp/portal.log')    
  def out = new File('result.log')
  out.write('') // create empty file
  def count=0
  boolean flag = false
 input.eachLine{ line ->
   if (line =~/\d\d\d\d-\d\d-\d\d \d\d:\d\d:\d\d,\d\d\d/){  //lines starting from date (for mask 2013-08-07 19:28:40,020)
       flag= false
      if (line =~ /scRRSCvPGvnk3cWywrGLGlJLSBmmpPxhfZxHr3dgYKPvh7GMPkGm/){  //and with session-hash
        flag=true
      } 
    }
   if (flag){   //copy into file until string will start from date without session-hash
    out << line + '\n' 
    count++
   } 
 }   
  Calendar stop = new GregorianCalendar()
end = stop.time
  println '\n Длительность: ' + (Math.abs(end.time - begin.time)/1000).toString()+' sec\n'
  println ' Lines found: '+ count
