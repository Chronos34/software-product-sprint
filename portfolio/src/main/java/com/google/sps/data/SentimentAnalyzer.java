// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.data;

import java.io.IOException;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Sentiment;
import com.google.cloud.language.v1.LanguageServiceClient;

/**
 * The purpose of this class is to create a dedicated
 * object for checking the negativity or postivity
 * of a comment made by a user.
 */
public final class SentimentAnalyzer {

    private float sentimentScore;
    private final String message;

    public SentimentAnalyzer(final String message) throws IOException {
        this.message = message;
        this.statementAnalysis();
    }

    public float getSentimentScore() {
        return sentimentScore;
    }

    private void statementAnalysis() throws IOException {
        final Document doc = 
        Document.newBuilder().setContent(this.message).setType(Document.Type.PLAIN_TEXT).build();
        
        final LanguageServiceClient languageService = LanguageServiceClient.create();
        final Sentiment sentiment = languageService.analyzeSentiment(doc).getDocumentSentiment();
        
        this.sentimentScore = sentiment.getScore();
        languageService.close();
    }
}