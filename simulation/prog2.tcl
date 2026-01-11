set ns [new Simulator]

set tracefile [open out.tr -w]
$ns trace-all $tracefile
set namfile [open out.nam -w]
$ns namtrace-all $namfile

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]

$ns duplex-link $n0 $n1 0.1Mb 10ms DropTail
$ns queue-limit $n0 $n1 10

$ns duplex-link $n1 $n2 0.1Mb 10ms DropTail
$ns queue-limit $n1 $n2 10

$ns duplex-link $n2 $n3 0.1Mb 10 DropTail
$ns queue-limit $n2 $n3 10

$ns duplex-link $n4 $n5 0.1Mb 10ms DropTail
$ns queue-limit $n4 $n5 10

$ns duplex-link $n3 $n4 0.1Mb 10ms DropTail
$ns queue-limit $n3 $n4 10

set p1 [new Agent/Ping]
set p2 [new Agent/Ping]

$ns attach-agent $n0 $p1
$ns attach-agent $n1 $p2

$ns connect $p1 $p2

Agent/Ping set packetSize_ 1000

$ns at 0.5 "$p1 send"
$ns at 1 "$p1 send"
$ns at 1.5 "$p1 send"
$ns at 2 "$p1 send"
$ns at 2.5 "$p1 send"
$ns at 3 "$p1 send"
$ns at 3.5 "$p1 send"
$ns at 4 "$p1 send"
$ns at 4.5 "$p1 send"


proc finish {} {
    global ns tracefile namfile
    $ns flush-trace
    close $tracefile
    close $namfile
    exec nam out.nam & 
    exit 0
}

$ns at 5 "finish"

$ns run 

# grep -c "d" out.tr |cut -d " " -f 5| grep -c "ping"