Test results:
-------

```
1 threads, Empty: 26672/msec, LockFree: 19797/msec, Locked: 17312/msec, Synch: 22562/msec, SpinLocked: 18705/msec
2 threads, Empty: 52171/msec, LockFree: 10348/msec, Locked: 7874/msec, Synch: 11462/msec, SpinLocked: 10434/msec
3 threads, Empty: 75496/msec, LockFree: 9972/msec, Locked: 10781/msec, Synch: 9741/msec, SpinLocked: 7456/msec
4 threads, Empty: 79313/msec, LockFree: 9737/msec, Locked: 10676/msec, Synch: 9267/msec, SpinLocked: 5539/msec
5 threads, Empty: 78081/msec, LockFree: 9066/msec, Locked: 10485/msec, Synch: 9126/msec, SpinLocked: 4622/msec
6 threads, Empty: 82747/msec, LockFree: 7882/msec, Locked: 10445/msec, Synch: 9387/msec, SpinLocked: 3411/msec
7 threads, Empty: 98181/msec, LockFree: 7436/msec, Locked: 10413/msec, Synch: 9657/msec, SpinLocked: 2900/msec
8 threads, Empty: 97073/msec, LockFree: 7281/msec, Locked: 10665/msec, Synch: 9552/msec, SpinLocked: 2464/msec
9 threads, Empty: 96757/msec, LockFree: 7174/msec, Locked: 10684/msec, Synch: 9695/msec, SpinLocked: 2262/msec
10 threads, Empty: 101204/msec, LockFree: 6481/msec, Locked: 10942/msec, Synch: 9667/msec, SpinLocked: 1928/msec
```

+ usleep(250) to the SpinLock through JNI
-------

```
1 threads, Empty: 25955/msec, LockFree: 19634/msec, Locked: 17054/msec, Synch: 21399/msec, SpinLocked: 17440/msec
2 threads, Empty: 49210/msec, LockFree: 10318/msec, Locked: 9744/msec, Synch: 11898/msec, SpinLocked: 17299/msec
3 threads, Empty: 71931/msec, LockFree: 10261/msec, Locked: 10298/msec, Synch: 9310/msec, SpinLocked: 17250/msec
4 threads, Empty: 69805/msec, LockFree: 10160/msec, Locked: 10316/msec, Synch: 9286/msec, SpinLocked: 17073/msec
5 threads, Empty: 72154/msec, LockFree: 9243/msec, Locked: 10262/msec, Synch: 8817/msec, SpinLocked: 16855/msec
6 threads, Empty: 87001/msec, LockFree: 7867/msec, Locked: 10377/msec, Synch: 8915/msec, SpinLocked: 16642/msec
7 threads, Empty: 93727/msec, LockFree: 7092/msec, Locked: 10295/msec, Synch: 9372/msec, SpinLocked: 16605/msec
8 threads, Empty: 97552/msec, LockFree: 6767/msec, Locked: 10223/msec, Synch: 8880/msec, SpinLocked: 16400/msec
9 threads, Empty: 93124/msec, LockFree: 7484/msec, Locked: 10431/msec, Synch: 8757/msec, SpinLocked: 16252/msec
10 threads, Empty: 101087/msec, LockFree: 6924/msec, Locked: 10422/msec, Synch: 9364/msec, SpinLocked: 16200/msec
```

+ usleep(250) to the LockFreeStack through JNI
```
1 threads, Empty: 26262/msec, LockFree: 19541/msec, Locked: 17271/msec, Synch: 21459/msec, SpinLocked: 17369/msec
2 threads, Empty: 50154/msec, LockFree: 19494/msec, Locked: 8264/msec, Synch: 11176/msec, SpinLocked: 17409/msec
3 threads, Empty: 74047/msec, LockFree: 19464/msec, Locked: 10376/msec, Synch: 9564/msec, SpinLocked: 17321/msec
4 threads, Empty: 75911/msec, LockFree: 19446/msec, Locked: 10158/msec, Synch: 9628/msec, SpinLocked: 17128/msec
5 threads, Empty: 79655/msec, LockFree: 19076/msec, Locked: 10362/msec, Synch: 9533/msec, SpinLocked: 16837/msec
6 threads, Empty: 85524/msec, LockFree: 19133/msec, Locked: 10391/msec, Synch: 9320/msec, SpinLocked: 16534/msec
7 threads, Empty: 95920/msec, LockFree: 19082/msec, Locked: 10208/msec, Synch: 9222/msec, SpinLocked: 16569/msec
8 threads, Empty: 95107/msec, LockFree: 18956/msec, Locked: 10291/msec, Synch: 9498/msec, SpinLocked: 16339/msec
9 threads, Empty: 100926/msec, LockFree: 18703/msec, Locked: 10499/msec, Synch: 9061/msec, SpinLocked: 16285/msec
10 threads, Empty: 94880/msec, LockFree: 18536/msec, Locked: 10529/msec, Synch: 9026/msec, SpinLocked: 16200/msec
```

usleep is key point


