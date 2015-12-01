/*
   Copyright 2015 Tobias Schumacher

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package de.tschumacher.sqsservice.message;

public class SQSMessage<T> {

	private T content;
	private final SQSCoder<T> coder;

	public SQSMessage(final SQSCoder<T> coder, final String content) {
		super();
		this.coder = coder;
		this.content = this.coder.encode(content);
	}

	public SQSMessage(final SQSCoder<T> coder, final T content) {
		super();
		this.coder = coder;
		this.content = content;
	}

	public T getContent() {
		return this.content;
	}

	public String getContentAsString() {
		return this.coder.decode(this.content);
	}

	public void setContent(final T content) {
		this.content = content;
	}

	public void setContent(final String content) {
		this.content = this.coder.encode(content);
	}

}