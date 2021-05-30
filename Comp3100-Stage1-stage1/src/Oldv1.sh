echo 'Compile'
javac *.java data/*.java scheduler/*.java

echo 'Run'
./test_results_v1_old "java Client" -o $1 -c other/ -n
