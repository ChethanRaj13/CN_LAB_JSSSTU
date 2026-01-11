set ns [new Simulator]

set tracefile [open out.tr w]
set namfile [open out.nam w]

$ns trace-all $tracefile
$ns namtrace-all $namfile

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]

set bw1 1Mb
set bw2 1Mb
set delay 10ms

$ns duplex-link $n0 $n1 $bw1 $delay DropTail
$ns duplex-link $n1 $n2 $bw2 $delay DropTail

$ns queue-limit $n0 $n1 10
$ns queue-limit $n1 $n2 10

set tcp [new Agent/TCP]
$ns attach-agent $n0 $tcp

set sink [new Agent/TCPSink]
$ns attach-agent $n2 $sink

$ns connect $tcp $sink

set ftp [new Application/FTP]
$ftp attach-agent $tcp

$ns at 0.1 "$ftp start"
$ns at 5 "$ftp stop"

proc finish {} {
  global ns tracefile namfile
  $ns flush-trace
  close $tracefile
  close $namfile
  exec nam out.nam &
  exit 0
}

$ns at 5.1 "finish"

$ns run 