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
public class QuizEntity {

    private String rule;
    private String question;
    private String answer;
    private String userAnswer;

    public QuizEntity() {
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String pRule) {
        this.rule = pRule;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String pQuestion) {
        this.question = pQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String pAnswer) {
        this.answer = pAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String pUserAnswer) {
        this.userAnswer = pUserAnswer;
    }

    @Override
    public String toString() {
        return "QuizC11Entity{" + "rule=" + rule + ", question=" + question + ", answer=" + answer + ", userAnswer=" + userAnswer + '}';
    }

}
