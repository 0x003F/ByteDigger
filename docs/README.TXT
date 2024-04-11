This is ByteDiggerJava, a malware detector developed entirely be me in Java.

The first version of this project was coded in C, but it wasn't user-friendly, it could scan only one path at a time and it was also resctricted to the use of a limited range of data.
So, I migrated the project in Java and I expanded its functionalities.

This malware detector uses, to report malicious files in the mass storage directory, the lists of MD5 checksums shared by VirusShare (https://virusshare.com/hashes).
Every MD5 hash in every .txt file corresponds to the MD5 checksum of one of the various viruses found, analyzed and shared by VirusShare.

As you can see in the link above, there are more than 400 hash lists shared by VirusShare.
I personally downloaded and included only the fist 14 of them in the project, but, if you want to safely use my algorithm, you'll need all of them.
To do that, first thing first, you must save each one as "VirusShareList(number of the list).txt" in the folder "data", then, you must set the private attribute "MAX_NUMBER_LISTS" at 400 if you downloaded all the lists until the number 400, or 450 ecc...

I recommend keeping the folder "data" updated, by visiting the link above some time to time and saving the latest files, following the procedure explained in the previous line.
