/*
MIT License

Copyright (c) 2020 cicciog

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE. 
*/
package quizLogic;

/**
 *
 * @author cicciog
 */
public class ResultEntity {
    
    private int score = 0;
    private int correct = 0;
    private int wrong = 0;
    private int notAnswered = 0;

    public ResultEntity() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int pScore) {
        this.score = pScore;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int pCorrect) {
        this.correct = pCorrect;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int pWrong) {
        this.wrong = pWrong;
    }

    public int getNotAnswered() {
        return notAnswered;
    }

    public void setNotAnswered(int pNotAnswered) {
        this.notAnswered = pNotAnswered;
    }

    @Override
    public String toString() {
        return "ResultEntity{" + "score=" + score + ", correct=" + correct + ", wrong=" + wrong + ", notAnswered=" + notAnswered + '}';
    }
       
    
    
}
